(defn square [x]
  (* x x))

(defn sum-two-largest-square [x y & rest]
  (apply + 
         (map square 
              (take 2 
                    (reverse 
                     (sort
                      (conj rest x y)))))))


;; (exercise-1-3 8 3 9 )
;; /media/nick/LaCie/BACKUP/projects/clojure_proj/exercise-1-3-2.clj
