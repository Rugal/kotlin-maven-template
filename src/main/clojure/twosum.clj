(ns twosum)

(defn solution "https://leetcode.com/problems/two-sum/" [nums target]
  (let [m (into {} (map-indexed (fn [i e] [e i]) nums))
        indexed (map-indexed (fn [i e] {:key i :value e}) nums)]
    (loop [current (first indexed)
           remain (rest indexed)]
      (if (nil? current)
        []
        (let [i (:key current)
              o (->> (:value current) (- target) (m))]
          (if (and (some? o) (not= i o))
            [i o]
            (recur (first remain) (rest remain))))))))
