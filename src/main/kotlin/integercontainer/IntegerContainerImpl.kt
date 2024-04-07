package integercontainer


interface IntegerContainer {
  /**
   * Should add the specified integer `value` to the container
   * and return the number of integers in the container after the
   * addition.
   */
  fun add(value: Int): Int {
    // default implementation
    return 0;
  }

  /**
   * Should attempt to remove the specified integer `value` from
   * the container.
   * If the `value` is present in the container, remove it and
   * return `true`, otherwise, return `false`.
   */
  fun delete(value: Int): Boolean {
    // default implementation
    return false;
  }

  /**
   * Should return the median integer - the integer in the middle
   * of the sequence after all integers stored in the container
   * are sorted in ascending order.
   * If the length of the sequence is even, the leftmost integer
   * from the two middle integers should be returned.
   * If the container is empty, this method should return `null`.
   */
  fun getMedian(): Int? {
    // default implementation
    return null;
  }
}

class IntegerContainerImpl : IntegerContainer {
  private val list = mutableListOf<Int>()

  override fun add(value: Int): Int {
    this.list.add(value)
    return list.size
  }

  override fun delete(value: Int): Boolean = this.list.remove(value)

  override fun getMedian(): Int? {
    if (this.list.isEmpty()) return null
    this.list.sort()
    var index = this.list.size / 2
    if (this.list.size % 2 == 0) {
      --index
    }
    return this.list[index]
  }
}
