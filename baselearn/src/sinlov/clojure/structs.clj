(ns sinlov.clojure.structs
  (:gen-class))


(defn Ex
  "docstring"
  []
  (def x (even? 0))
  (println x)
  (def x (pos? 3))
  (println x)
  (def x (neg? 2))
  (println x)

  (def my_v [1 2 3 4])
  (let [[a b c d e] my_v]
  (println a b c d e))


)

(Ex)