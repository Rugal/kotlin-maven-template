package kidswiththegreatestnumberofcandies

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 */
class Solution {
  fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val maxValue = candies.max()
    return candies.map { it + extraCandies >= maxValue }
  }
}
