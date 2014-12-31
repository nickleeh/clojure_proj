(defn to-radix
  "Input a number and the radix in demand.
   Output the number represented in that radix." 
  [int r]
  (.toString (biginteger int) r))

;; (to-radix 255 2)
;; => "11111111"

(defn from-radix
  "Input a number in string format and its radix.
   Output the number in decimal."
  [str r]
  (BigInteger. str r))

;; (from-radix "11111111" 2)
;; => 255
