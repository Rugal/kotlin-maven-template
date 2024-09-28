(ns greatest-common-divisor-of-strings)

(defn- gcd [origin sub]
  (let [l1 (count origin)
        l2 (count sub)]
    (if (not= 0 (mod l1 l2))
      false
      (= origin (apply str (repeat (quot l1 l2) sub))))))

(defn solution "https://leetcode.com/problems/greatest-common-divisor-of-strings" [s1 s2]
  (loop [i 0
         current ""
         result ""]
    (if (or (not= (get s1 i) (get s2 i)) (= i (min (count s1) (count s2))))
      result
      (let [next (str current (get s1 i))]
        (recur
          (inc i)
          next
          (if (and (gcd s1 next) (gcd s2 next)) next result))))))
