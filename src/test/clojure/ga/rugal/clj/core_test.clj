(ns ga.rugal.clj.core-test
  (:require [clojure.test :refer :all]
            [ga.rugal.clj.core :refer :all]))

(deftest mix
  (testing "mix compilation"
    (is (= "Grazie Rugal!" (hello "Rugal")))))

(testing "Arithmetic"
  (testing "with positive integers"
    (is (= 4 (+ 2 2)))
    (is (= 7 (+ 3 4))))
  (testing "with negative integers"
    (is (= -4 (+ -2 -2)))
    (is (= -1 (+ 3 -4)))))
