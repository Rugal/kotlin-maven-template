(ns mergestringsalternately-test
  (:require [clojure.test :refer :all]
            [mergestringsalternately :refer [solution]]))

(deftest solution-test
  (is (= "apbqcr" (solution "abc" "pqr")))
  (is (= "apbqrs" (solution "ab" "pqrs")))
  (is (= "apbqcd" (solution "abcd" "pq")))
  )
