package amazoninterview

import java.time.Instant

class Q2 {
}


// We are working on a shopping website and we want to analyze the least active 
// users to offer them some promotions to get their engagement up again.

// We know that every user has their unique usernames, 
// so we can track whether they are visiting the website again or not.

// You have a constant stream of user log in events like [john, jeff, jeff, chriss, john, adam, sandy]   n entries in last 24H
// The amount of the logins is thousands per minute

// newUserLogin(username): This method will be called every time a user logs in
// getLeastActiveUsers(): This method will return the usernames of the 
// customers with the least logins in the past 24 hours

// Implement these 2 methods

// Example:

// newUserLogin(john);
// newUserLogin(jeff);
// newUserLogin(jeff);
// getLeastActiveUsers(); should return john


//data class Login(
//  name: String,
//  time: Long = Instant.now().epochSecond,
//)
//
//class LeastActiveUserAnalyzer {
//
//  val logins = mutableListOf<Login>()
//
//  private fun dropExpired() {
//    // drop those that expired(more than 24H)
//    val expired = Instant.now().epochSecond - 24 * 60 * 60 // oldest epoch second that is yet to expire
//    for(item in this.logins) {
//      if(item.time < expired) {
//        this.logins.remove(item)
//      } else {
//        break
//      }
//    }
//  }
//
//  fun newUserLogin(name: String) {
//    dropExpired()
//    // add new login
//    this.logins += Login(name)
//  }
//
//  fun getLeastActiveUsers(): List<String> {
//    dropExpired()
//    val map = mutableMapOf<String, Int>()
//    // count how many logins for each name
//    for(item in this.logins) {
//      map[item.name] = map.getOrDefault(item.name, 0) + 1
//    }
//    // sort the entry pair by count in ascending order
//    val sorted: List<Entry<String, Int>> = map.entries.sortBy(it.value) // FIXME: O(n^2)
//    val count = sorted[0].value
//    val result = mutableListOf<String>()
//    for(item in sorted) {
//      if (item.value == count) {
//        result.add(item.key)
//      }
//    }
//    return result
//  }
//}
