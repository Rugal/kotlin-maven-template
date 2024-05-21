package optimization

import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.util.StopWatch

class BlockingTest {
  private val LOG = KotlinLogging.logger { }


  private fun test1(): Int {
    TimeUnit.SECONDS.sleep(2L)
    return 1
  }

  private fun test2(): Int {
    TimeUnit.SECONDS.sleep(2L)
    return 2
  }

  private fun test3(): Int {
    TimeUnit.SECONDS.sleep(2L)
    return 3
  }

  @DisplayName("basic")
  @Test
  fun testBlocking() {
    var result = 0

    val w = StopWatch()
    w.start()
    result += test1()
    result += test2()
    result += test3()
    w.stop()

    LOG.info { "Result $result; time ${w.totalTimeMillis}" }
  }

  @DisplayName("future")
  @Test
  fun testFuture() {
    var result = 0

    val w = StopWatch()
    w.start()
    val f1: CompletableFuture<Int> = CompletableFuture.supplyAsync { this.test1() }.exceptionally { 0 }
    val f2: CompletableFuture<Int> = CompletableFuture.supplyAsync { this.test2() }.exceptionally { 0 }
    val f3: CompletableFuture<Int> = CompletableFuture.supplyAsync { this.test3() }.exceptionally { 0 }

    CompletableFuture.allOf(f1, f2, f3).join()

    result += f1.get()
    result += f2.get()
    result += f3.get()
    w.stop()

    LOG.info { "Result $result; time ${w.totalTimeMillis}" }
  }


  private suspend fun suspended(f: () -> Int): Int = withContext(Dispatchers.IO) { f() }

  @DisplayName("coroutine")
  @Test
  fun coroutine() {
    runBlocking {
      val w = StopWatch()
      w.start()

      val a1 = async { suspended(::test1) }
      val a2 = async { suspended(::test2) }
      val a3 = async { suspended(::test3) }
      val a = awaitAll(a1, a2, a3)

      var result = 0

      result += a[0]
      result += a[1]
      result += a[2]
      w.stop()

      LOG.info { "Result $result; time ${w.totalTimeMillis}" }
    }
  }
}
