(ns sinlov.clojure.helloIO
  (:gen-class))

((defn example1 []
   (with-open [rdr (clojure.java.io/reader "/Users/wangchangye/WorkSpace/clojure/baselearn/example.txt") ]
     (reduce conj [] (line-seq rdr)))))

(example1)

((defn hello_world
  []
   (println "hello world")
   (println "app")
   (println (clojure.string/replace "the groovy" #"groovy" "clojure"))
   (println (clojure.string/split-lines "hello\nworld"))

    (println (sorted-set '(1 2 3 , 4)))
   (println (nth (vector 1 2,3) 0))
   (println (nth (vector 1 2,3) 2))
   (def demokeys (sorted-map "z" "1" "b" "2" "a" "3"))
   (println demokeys)
    (println (get demokeys "b"))
   (println (seq [1 2 3]))
   (def pat (re-pattern "\\d+"))
   (println (re-find pat "abcdef112"))
   ))
;;(hello_world)
(defn Example []
  (try
    (aget (int-array [1 2 3]) 5)

    (catch Exception e (println (str "caught exception: " (.toString e))))
    (finally (println "This is our final block")))
  (println "Let's move on"))
(Example)

(defn Example1 []
  (defstruct Employee :EmployeeName :Employeeid)
  (def emp (struct-map Employee :EmployeeName "John" :Employeeid 1))
  (println (:Employeeid emp))
  (println (:EmployeeName emp)))
(Example1)
