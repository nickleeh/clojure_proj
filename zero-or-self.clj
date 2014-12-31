;; (import '(java.lang.RuntimeException CompilerException))
;; (import '(clojure.lang.Util RuntimeException))
(defn zero-or-self [num]
  ;;  {:pre ([number? num])}
  (try
    (if (== 0 num)
      "The number is zero."
      num)
    (catch ArithmeticException e (println "Divide by zero"))
    (catch Exception e (println "Not a number."))))
