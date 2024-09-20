(ns ga.rugal.clj.core
  (:import [ga.rugal Sample]))

(defn hello [name]
  (let [k (Sample.)]
    (.exclamation k (str "Grazie " name))))
