(ns single-number-ii-test
  (:require [clojure.test :refer :all]
            [single-number-ii :refer :all]))

(deftest solution-test
  (is (= 3 (solution [2 2 3 2])))
  (is (= 99 (solution [0 1 0 1 0 1 99]))))
