import clojure.java.api.Clojure
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RugalTest {

  @Test
  fun cross() {
    Clojure.`var`("clojure.core", "require")(Clojure.read("ga.rugal.clj.core"))
    Assertions.assertEquals("Grazie Rugal!", Clojure.`var`("ga.rugal.clj.core", "hello")("Rugal"))
  }
}
