(defn exercise-1-3 [x y z]
(apply + (map square (take 2 (sort [x y z])))))

(defn square [x]
  (* x x))

(exercise-1-3 3 4 5)
