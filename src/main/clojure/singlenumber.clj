(ns singlenumber)

(defn ^Integer solution "https://leetcode.com/problems/single-number" [^clojure.lang.PersistentVector nums]
  (reduce bit-xor nums))
