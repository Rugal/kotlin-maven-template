(ns single-number-ii)

(defn- c [a b i] (bit-xor a (bit-and (bit-not b) i)))

(defn- f [acc i]
  (let [o (c (first acc) (last acc) i)
        t (c (last acc) o i)]
    [o t]))

(defn solution "https://leetcode.com/problems/single-number-ii" [^clojure.lang.PersistentVector nums]
  (-> (reduce f [0 0] nums)
      (first)))
