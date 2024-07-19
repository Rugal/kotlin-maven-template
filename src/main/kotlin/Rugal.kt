fun main() {

}

class Rugal {
  private var counter = 0

  fun test() {
    synchronized(this) {
      this.counter++
    }
  }
}
