(defn fixed-length-password
  ([] (fixed-length-password 8))
  ([n]
   (let [chars (map char (range 33 127))
         password (take n (repeatedly #(rand-nth chars)))]
     (reduce str password))))   


(defn fixed-length-password
  ([] (fixed-length-password 8))
  ([n]
   (->> #(rand-nth (map char (range 33 127)))
        repeatedly
        (take n) 
        (reduce str))))
