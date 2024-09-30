(ns reverse-vowels-of-a-string-test
  (:require [clojure.test :refer :all]
            [reverse-vowels-of-a-string :refer [solution]]))

(deftest solution-test
  (is (= "AceCreIm" (solution "IceCreAm")))
  (is (= "leotcede" (solution "leetcode")))
  )
