(ns twosum-test
  (:require [clojure.test :refer :all])
  (:require [twosum :refer :all]))

(deftest solution-test
  (is (= [0 1] (solution [2 7 11 15] 9)))
  (is (= [1 2] (solution [3 2 4] 6)))
  (is (= [0 1] (solution [3 3] 6))))
