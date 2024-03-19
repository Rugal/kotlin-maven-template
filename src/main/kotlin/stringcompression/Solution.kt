package stringcompression

/**
 * https://leetcode.com/problems/string-compression
 */
class Solution {
  fun compress(chars: CharArray): Int {
    var result = 0// the size of final result as result

    var index = 1 // the current index to inspect in original array
    var size = 1  // the number of currently compressing character
    var c = chars[0] // current character to compress

    while (index < chars.size) {
      if (chars[index] == c) {
        ++size
      } else {
        // to write previous character
        chars[result++] = c
        if (size != 1) {
          for (s in size.toString()) {
            chars[result++] = s
          }
        }
        c = chars[index]
        size = 1
      }

      ++index
    }

    // to write previous character
    chars[result++] = c
    if (size != 1) {
      for (s in size.toString()) {
        chars[result++] = s
      }
    }

    println(result)
    return result
  }
}
