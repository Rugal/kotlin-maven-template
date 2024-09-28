(ns coinchange-test
  (:require [clojure.test :refer :all]
            [coinchange :refer :all]))

(deftest solution-test
  (is (= 3 (solution [1 2 5] 11)))
  (is (= -1 (solution [2] 3)))
  (is (= 0 (solution [1] 0)))
  )
