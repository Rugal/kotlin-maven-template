package asteroidcollision

import java.util.Stack

/**
 * https://leetcode.com/problems/asteroid-collision
 */
class Solution {
  fun asteroidCollision(asteroids: IntArray): IntArray {
    val s = Stack<Int>()
    for (a in asteroids) {
      // <- <-
      // -> ->
      // <- ->
      // these 3 do not have problem
      if (s.isEmpty() || a > 0 || s.peek() < 0) {
        s.push(a)
        continue
      }
      // -> <- this will collide
      while (s.isNotEmpty()) {
        // if top is negative as well
        if (s.peek() < 0) {
          s.push(a)
          break
        }
        // if top is positive
        // - if larger than new, erase new, exit
        if (s.peek() > a * -1) break
        // - if they have same size
        if (s.peek() == a * -1) {
          // do not push, but also erase the top, exit
          s.pop()
          break
        }
        // new is larger than top, pop top and keep colliding
        s.pop()
        // if there is no more element after pop, still need to insert and exit
        if (s.isEmpty()) {
          s.push(a)
          break
        }
      }
    }

    return s.toIntArray()
  }
}
