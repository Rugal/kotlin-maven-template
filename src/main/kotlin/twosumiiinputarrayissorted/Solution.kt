package twosumiiinputarrayissorted

class Solution {
  fun twoSum(numbers: IntArray, target: Int): IntArray {
    var begin = 0
    var end = numbers.size - 1

    while (begin < end) {
      val value = numbers[begin] + numbers[end]
      if (value == target) return intArrayOf(begin + 1, end + 1)

      if (value < target) {
        ++begin
      } else {
        --end
      }
    }
    return intArrayOf()
  }
}
