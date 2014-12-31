(defn as-int
  [s]
  (try
    (Integer/parseInt s)
    (catch Exception e
      ;;      (.printStackTrace e))
      (println "Not a number."))
    (finally
      (println "Attempted to parse as integer: " s))))
