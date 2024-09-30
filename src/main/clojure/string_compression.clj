(ns string-compression)

(defn solution "https://leetcode.com/problems/string-compression" [chars]
  (loop [current-char (first chars)
         remain-chars (rest chars)
         counter 0
         result []]
    (if (nil? current-char)
      (clojure.string/join "" (if (> counter 1) (conj result counter) result))
      (let [previous-char (last result)
            ; reset to 1 if new character
            next-counter (if (= previous-char current-char) (inc counter) 1)
            ; append number only if more than 1, then append current-char character
            next-result (if (= previous-char current-char)
                          result
                          (let [t (if (> counter 1) (conj result counter) result)]
                            (conj t current-char)))]
        (recur
          (first remain-chars)
          (rest remain-chars)
          next-counter
          next-result)))))
