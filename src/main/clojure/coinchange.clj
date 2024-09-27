(ns coinchange)

(defn solution "https://leetcode.com/problems/coin-change/description/" [coins amount]
  (loop [result (-> (repeat (inc amount) Integer/MAX_VALUE) vec (assoc 0 0))
         a 1
         coin (first coins)
         remain (rest coins)]
    (if (= a (inc amount))
      (let [value (last result)] (if (= value Integer/MAX_VALUE) -1 value))
      (let [r (- a coin)
            is-empty (empty? remain)
            next-amount (if is-empty (inc a) a)
            next-coin (if is-empty (first coins) (first remain)) ;no coin to use, next amount, reset coin
            next-remain (if is-empty (rest coins) (rest remain)) ;more coin to use, next coin, same amount
            is-match (and (>= r 0)
                          (not= Integer/MAX_VALUE (nth result r))
                          (> (nth result a) (inc (nth result r))))
            next-result (if is-match (assoc result a (inc (nth result r))) result)
            ]
        (recur next-result next-amount next-coin next-remain))))) 
