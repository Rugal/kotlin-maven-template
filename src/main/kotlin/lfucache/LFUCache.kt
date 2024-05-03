package lfucache

/**
 * https://leetcode.com/problems/lfu-cache/
 */
class LFUCache(private val capacity: Int) {
  // key: original key, value: frequency and original value.
  private val cache = mutableMapOf<Int, Pair<Int, Int>>()

  // key: frequency, value: All keys that have the same frequency.
  private val frequencies = mutableMapOf<Int, LinkedHashSet<Int>>()
  private var minimum: Int = 0

  private fun insert(key: Int, frequency: Int, value: Int) {
    cache[key] = frequency to value
    frequencies.computeIfAbsent(frequency) { LinkedHashSet() }.add(key)
  }

  fun get(key: Int): Int {
    val frequencyAndValue = cache[key] ?: return -1

    val frequency = frequencyAndValue.first

    // remove previous one
    frequencies[frequency]!!.also {
      it.remove(key)
      if (it.isEmpty()) {
        frequencies.remove(frequency)
        if (minimum == frequency) ++minimum
      }
    }

    // re-insert with additional frequency
    insert(key, frequency + 1, frequencyAndValue.second)
    return frequencyAndValue.second
  }

  fun put(key: Int, value: Int) {
    if (capacity <= 0) return

    val frequencyAndValue = cache[key]
    if (frequencyAndValue != null) {
      // update with new value
      cache[key] = frequencyAndValue.first to value
      // update frequency
      get(key)
      return
    }
    // evict if more than capacity
    if (capacity == cache.size) {
      val keys = frequencies[minimum]!!
      val keyToDelete = keys.iterator().next()
      // remove least frequent key
      cache.remove(keyToDelete)
      keys.remove(keyToDelete)
      if (keys.isEmpty()) {
        frequencies.remove(minimum)
      }
    }
    // now this is only one 
    minimum = 1
    insert(key, 1, value)
  }
}
