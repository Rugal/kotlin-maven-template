(ns greatest-common-divisor-of-strings-test
  (:require [clojure.test :refer :all]
            [greatest-common-divisor-of-strings :refer [solution]]))

(deftest solution-test
  (is (= "ABC" (solution "ABCABC" "ABC")))
  (is (= "AB" (solution "ABABAB" "ABAB")))
  (is (= "" (solution "LEET" "CODE")))
  )
