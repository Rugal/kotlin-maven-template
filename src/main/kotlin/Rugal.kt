class Container<out T>

fun main() {
  val a: Container<String> = Container()
  val b: Container<Any> = a
}

/*
// should only use as return value, never as input parameter

class Base<out T> {
  fun get(): T {
  }
}

fun main() {
  val a = Base<String>()

  val b: String = a.get()
  val c: Any = a.get()
}
 */

/*
// should only use as input parameter, never as return value

class Base<in T> {
  fun add(data: T) {
  }
}

fun main() {
  val a = Base<Any>()
  a.add("string")
  a.add(1 to 2)
}
 */
