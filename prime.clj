;; Primality check.
;; Algorithm: Miller-Rabin
;; implemented in Java's BigInteger#isProbablePrime.

(def certainty 5)
;; certainty - a measure of the uncertainty that the caller is willing
;; to tolerate: if the call returns true the probability that this
;; BigInteger is prime exceeds (1 - 0.5^certainty). The execution time
;; of this method is proportional to the value of this parameter.

(defn prime? [n]
  "Return whether n is prime."
  (.isProbablePrime (BigInteger/valueOf n) certainty))

;; Usage example: effectively take 10001 primes starting from 3. Don't forget "2".
(conj (take 10001 
            (filter prime? 
                    (take-nth 2 
                              (range 1 Integer/MAX_VALUE)))) 2)

;; Or use thread macro:
(->> (range 1 Integer/MAX_VALUE)
     (take-nth 2)
     (filter prime?)
     (take 10001)
     (cons 2))

;; Result => (2 3 5 7 11 13 17 19 23 29 31 37 41 ...

(defn why-not-prime [n]
  "Return the smallest divisor if n is not a prime."
  {:pre [(> n 1)]}
  (let[checker (fn [divisor]                ; A local function under the name checker, with one argument
                 (if (= 0 (mod n divisor))  ; If that argument is a divisor of n
                   divisor                  ; then return it
                   false))                  ; otherwise return false - this value wasn't "appropriate"
       witness (some checker (range 2 n))]  ; witness will be the first value that satisfies checker
                                            ; if there isn't such a value, witness is nil
    (if witness
      (str n " is composite because it can be divided by " witness)
      (str n " is prime."))))
