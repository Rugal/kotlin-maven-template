package minimumnumberofarrowstoburstballoons

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 */
class Solution {
  fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortWith { a, b ->
      if (a[0] != b[0])
        if (a[0] < b[0]) -1 else 1
      else
        if (a[1] < b[1]) -1 else 1
    }

    var count = 1 // how many shot to do
    var right = points[0][1] // the right bound of balloon to look for

    for (i in 1 until points.size) {
      /*
        1. no overlap, must make another shot
        [   ]
                [   ]
       */
      if (right < points[i][0]) {
        ++count
        right = points[i][1]
        continue
      }
      /*
        2. need to shrink to internal balloon
        [       ]
           [ ]
       */
      if (points[i][1] < right) {
        right = points[i][1]
      }
      /*
        3. regular case, do nothing
        [    ]
           [    ]
       */
    }

    return count
  }
}
