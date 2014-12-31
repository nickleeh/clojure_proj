(defn square [x]
  (* x x))

(defn exercise-1-3 [x y z]
  (apply + 
         (map square 
              (take 2 
                    (reverse (sort [x y z]))))))



;; (exercise-1-3 8 3 9 )
