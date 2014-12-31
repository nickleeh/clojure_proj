(defn mean [coll]
  (let [sum (apply + coll)
        count (count coll)]
        (if (pos? count)
        (/ sum count)
        0)))

;; (mean [3 5])
(mean [3 45 3])

(print "hello")

(+ 4 5)
