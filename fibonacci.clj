(defn fib [n]
  "Return the nth Fibonacci number.
   Algorithm: Fast doubling (matrix)
   Given F(k) and F(k+1), we can calculate these:
   F(2k)F(2k+1)=F(k)[2F(k+1)−F(k)].=F(k+1)2+F(k)2."
  (let [fib* (fn fib* [n]
               (if (zero? n)
                 [0 1]
                 (let [[a b] (fib* (quot n 2))
                       c (*' a (-' (*' 2 b) a))           ; a(2b-a)
                       d (+' (*' b b) (*' a a))]          ; b^2 + a^2
                   (if (even? n)
                     [c d]
                     [d (+' c d)]))))]                    ; [d c+d]
    (first (fib* n))))

;; --------------------------------
(defn fib-pair [[a b]]
  "Return the next Fibonacci pair number based on input pair."
  [b (+' a b)])                                           ; Use +' for automatic handle large numbers (Long -> BigInt).

;; (defn fib-nth [x]
;;   "Return the nth Fibonacci number."
;;   (nth (map first (iterate fib-pair [0 1])) x))

(defn fib-seq [y]
  "Return first n Fibonacci sequence."
  (take y (map first (iterate fib-pair [1 1]))))

(defn fib-take-some [m n]
  "Return m-th to n-th (inclusive) Fibonacci sequence."
  (drop (dec m) (take n (map first (iterate fib-pair [1 1])))))


;; --------------------------------

;; (defn is-a-fib? [x]
;;   "Check whether x is a fibonacci number.
;;    Algorithm: test whether 5x^2+4 or 5x^2-4 is a perfect square."
;;   (let [a (+' (*' (Math/pow x 2) 5) 4)                      ; 5x^2+4
;;         b (-' (*' (Math/pow x 2) 5) 4)                      ; 5x^2-4
;;         sqrt-a (Math/sqrt a)
;;         sqrt-b (Math/sqrt b)]
;;     (or (== (*' sqrt-a sqrt-a)
;;             (*' (Math/floor sqrt-a) (Math/floor sqrt-a)))  ; Test whether n is a perfect square
;;         (== (*' sqrt-b sqrt-b)
;;             (*' (Math/floor sqrt-b) (Math/floor sqrt-b))))))



;; This Java implementation
;; http://faruk.akgul.org/blog/javas-missing-algorithm-biginteger-sqrt/
;; can be translated to Clojure:

(defn integer-sqrt [n]
  (let [n (biginteger n)]
    (loop [a BigInteger/ONE
           b (-> n (.shiftRight 5) (.add (biginteger 8)))]
      (if (>= (.compareTo b a) 0)
        (let [mid (-> a (.add b) (.shiftRight 1))]
          (if (pos? (-> mid (.multiply mid) (.compareTo n)))
            (recur a (.subtract mid BigInteger/ONE))
            (recur (.add mid BigInteger/ONE) b)))
        (dec a)))))

;; With that in place, you can define an arbitrary-precision perfect square test:

(defn perfect-square? [n]
  (let [x (integer-sqrt n)]
    (= (*' x x) n)))

;; And update your implementation to use it:

(defn is-a-fib? [x]
  "Check whether x is a fibonacci number.
   Algorithm: test whether 5x^2+4 or 5x^2-4 is a perfect square."
  (let [a (+' (*' (*' x x) 5) 4)                            ; 5x^2+4
        b (-' (*' (*' x x) 5) 4)]                           ; 5x^2-4
    (or (perfect-square? a)
        (perfect-square? b))))
