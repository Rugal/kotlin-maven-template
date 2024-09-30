(ns reverse-vowels-of-a-string)

(defn solution "https://leetcode.com/problems/reverse-vowels-of-a-string" [input]
  (let [c (->> input
               (map-indexed (fn [i e] {i e}))
               (into {})
               (filter (comp #{\a \e \i \o \u \A \E \I \O \U} last)))
        l (count c)
        vi (vec input)]
    (if (= l 0)
      input
      (loop [left 0
             right (dec l)
             s vi]
        (let [left-entry (nth c left)
              right-entry (nth c right)]
          (if (>= left right)
            (clojure.string/join "" s)
            (recur (inc left) (dec right) (as-> s x (assoc x (first left-entry) (last right-entry)) (assoc x (first right-entry) (last left-entry))))
            ))))))
