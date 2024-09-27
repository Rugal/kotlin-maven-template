fun main() {

}

class Rugal {

  fun a(f: () -> Unit) {}

  fun b() {}

  private var counter = 0

  fun test() {
    
    a(::b)
    synchronized(this) {
      this.counter++
    }
  }
}
