(defn opt1 []
  (def samp (map #(clojure.string/split % #"\|") (clojure.string/split-lines (slurp "cust.txt"))))
  (def customer (map #(hash-map (first %1) (vec (rest %1))) samp))
  (def mergedCustomer (apply merge customer))
  (into (sorted-map) mergedCustomer))


(defn opt2 []
  (def samp2 (map #(clojure.string/split % #"\|") (clojure.string/split-lines (slurp "prod.txt"))))
  (def prod (map #(hash-map (first %1) (vec (rest %1))) samp2))
  (def mergedProd (apply merge prod))
  (into (sorted-map) mergedProd))
   

(defn opt3 []
  (def samp3 (map #(clojure.string/split % #"\|") (clojure.string/split-lines (slurp "sales.txt"))))
  (def sales (map #(hash-map (first %1) (vec (rest %1))) samp3))
  (def mergedSales (apply merge sales))
  (into (sorted-map) mergedSales))

(def cust(opt1)) 
(def prod(opt2)) 
(def sales(opt3))
   

(println "enter customername")
(def cname(read-line))
(println cname)


; for the option 4
;(defn ccc[custName]
;  (first(reduce-kv (fn [acc k v]
;    (if (=(get v 0)(str custName))
;      (conj acc k)
;      acc))
;   #{} cust)))
;
;
;(defn cccc[custName]
;   (first(reduce-kv (fn [acc k v]
;    (if (=(name k)(str custName))
;      (conj acc (get v 1))
;      acc))
;   #{} prod)))
;
;(defn opt4 [] 
; (println "enter customername")
; (let[cname(read-line)]
;  (println cname ":" (reduce + (into [] (reduce-kv (fn[acc k v]
;     (if (= (get v 0)(str(name (ccc cname))))
;       (conj acc(*(Integer/parseInt (cccc (str(get v 1))))(Integer/parseInt (get v 2))))
;     acc))
;   #{} sales))))))
;   




(defn salesMenu []
   (println "*** Sales Menu ***
------------------
1. Display Customer Table
2. Display Product Table
3. Display Sales Table
4. Total Sales for Customer
5. Total Count for Product
6. Exit
Enter an option?"))



(defn choice []
  (salesMenu)
(let [option (Integer/parseInt (read-line))]
  (cond
    (= 1 option) (doseq [[k v] cust]
                  (println k ":" "["(get v 0) "," (get v 1) "," (get v 2) "]"))
    (= 2 option)  (doseq [[k v] prod]
                   (println k ":" "["(get v 0)"," (get v 1) "]"))
    (= 3 option)  (doseq [[k v] sales]
                   (println k ":" "["(get (get cust (get v 0)) 0)"," (get (get prod (get v 1)) 0) "," (get v 2) "]"))
    (= 4 option) (opt4)
    (= 5 option) (println "5 choice")
    (= 6 option) (println "Good Bye")
    :else (println "Sorry... Please enter valid number!"))))
(choice)
;(defn  temp []
;  (println (get cust(get v 0))))


;(defn choice []
;  (salesMenu)
;(let [option (Integer/parseInt (read-line))]
;   (if (= 1 option)(do(doseq [[k v] cust]
;                  (println k ":" "["(get v 0) "," (get v 1) "," (get v 2) "]")))
;                  ))))   
;(choice)








