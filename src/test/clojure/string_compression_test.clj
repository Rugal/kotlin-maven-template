(ns string-compression-test
  (:require [clojure.test :refer :all]
            [string-compression :refer [solution]]))

(deftest solution-test
  (is (= "a2b2c3" (solution ["a", "a", "b", "b", "c", "c", "c"])))
  (is (= "a" (solution ["a"])))
  (is (= "ab12" (solution ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"])))
  (is (= "ab2a" (solution ["a" "b" "b" "a"])))
  )
