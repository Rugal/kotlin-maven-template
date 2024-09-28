(ns mergestringsalternately)

(defn solution "https://leetcode.com/problems/merge-strings-alternately" [word1 word2]
  (let [l1 (count word1)
        l2 (count word2)
        r (if (>= l1 l2) (subs word1 l2 l1) (subs word2 l1 l2))]
    (as-> (map (fn [a b] (str a b)) word1 word2) v
          (clojure.string/join "" v)
          (str v r))))
