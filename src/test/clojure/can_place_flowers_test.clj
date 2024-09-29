(ns can-place-flowers-test
  (:require [clojure.test :refer :all])
  (:require [can-place-flowers :refer [solution]]))

(deftest solution-test
  (is (= true (solution [1 0 0 0 1] 1)))
  (is (= false (solution [1 0 0 0 1] 2)))
  )
