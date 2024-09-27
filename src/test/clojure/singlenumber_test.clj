(ns singlenumber-test
  (:require [clojure.test :refer :all]
            [singlenumber :refer :all]))

(deftest test
  (is (= 1 (solution [2 2 1])))
  (is (= 4 (solution [4 1 2 1 2])))
  (is (= 1 (solution [1]))))
