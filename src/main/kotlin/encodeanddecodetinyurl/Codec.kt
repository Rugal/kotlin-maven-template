package encodeanddecodetinyurl

import kotlin.random.Random

private val BASE58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"

class Codec {
  private val cache = mutableMapOf<String, String>()

  private fun getKey(length: Int): String = StringBuilder().let {
    for (i in 1..length) {
      it.append(BASE58[Random.nextInt(58)])
    }
    it.toString()
  }

  // Encodes a URL to a shortened URL.
  fun encode(longUrl: String): String {
    var key = ""
    do {
      key = getKey(6)
    } while (this.cache.containsKey(key))

    this.cache[key] = longUrl

    return "http://tinyurl.com/$key"
  }

  // Decodes a shortened URL to its original URL.
  fun decode(shortUrl: String): String =
    this.cache.getOrDefault(this.cache[shortUrl.replace("http://tinyurl.com/", "")], "")
}
