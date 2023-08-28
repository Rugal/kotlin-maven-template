import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RugalTest {
  @Test
  fun bernstein() {
    Assertions.assertTrue(Rugal().bernstein())
    // Assertions.assertFalse(Rugal().bernstein()) // this will fail test
  }
}
