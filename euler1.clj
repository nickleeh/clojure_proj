(defn e1 [limit]
  (reduce + (filter #(or (zero? (mod % 3))
			 (zero? (mod % 5)))
		    (take (- limit 1) (iterate inc 1)))))
(e1 1000)

;; user=> 233168
