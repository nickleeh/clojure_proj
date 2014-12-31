(defn next-terms [term-1 term-2]
  "Returns the next number of the Fibonacci sequence."
  (let [term-3 (+ term-1 term-2)]
    (lazy-seq
     (cons term-3
           (next-terms term-2 term-3)))))

(defn fibonacci [t1 t2]
  "Return a lazy sequence of Fibonacci number starts at t1."
  (concat [t1 t2]
          (next-terms t1 t2)))

;; Check whether x is a Fibonacci number:
(defn is-a-fib? [x]
  "Checks whether x belongs to a Fibonacci sequence."
  (cond 
   (= 0 x) true
   :else
   (let [n (Math/ceil (/ (Math/log x) 
                         (Math/log 2)))
         m (* 2 (+ n 10))]
     (contains? (set (take m (fibonacci 0 1N))) x))))



;; Algorithm 2: Perfect square (5n^2 + 4) or (5n^2-4)
(defn is-perfect-square? [x]
"Returns whether a number is a perfect square."
	(== (* (Math/sqrt x) (Math/sqrt x))  x))

(defn is-a-fib-2? [x]
"Checks whether x is a fibonacci number."
	(or (is-perfect-square? (+ (* 5 x x) 4))
	    (is-perfect-square? (- (* 5 x x) 4))))
