(ns can-place-flowers)

(defn- placeable "can place flower at this very index" [flowerbed i]
  (and
    (or
      (= i 0)
      (= 0 (get flowerbed (dec i))))
    (or
      (= (-> flowerbed count dec) i)
      (= 0 (get flowerbed (inc i))))))

(defn solution "https://leetcode.com/problems/can-place-flowers" [flowerbed n]
  (loop [fb flowerbed
         m n
         i 0]
    (if (or (= 0 m) (= (count fb) i))
      (= 0 m)
      (let [can-place (and (not= 1 (get fb i)) (placeable fb i))]
        (recur (if can-place (assoc fb i 1) fb) (if can-place (dec m) m) (inc i))
        )))) 
