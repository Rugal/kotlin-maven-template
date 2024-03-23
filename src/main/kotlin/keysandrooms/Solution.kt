package keysandrooms

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/keys-and-rooms
 */
class Solution {
  fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val locked = (1 until rooms.size).toMutableSet()
    val q: Queue<Int> = LinkedList()
    rooms[0].forEach(q::offer) // add all keys from room 0

    while (q.isNotEmpty()) {
      val key = q.poll()
      // check if this key can open new room
      if (locked.contains(key)) {
        // if true, discard this key
        locked.remove(key) // remove that room from locked set
        rooms[key].forEach(q::offer) // add all keys from room [key]
      }
    }

    return locked.isEmpty()
  }
}
