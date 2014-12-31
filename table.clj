(defn table [xs & {:keys [cols direction]
                   :or   {cols 1 direction 'right}}]
  (into []
        (condp = direction
          'down (let [c (count xs)
                      q (int (/ c cols))
                      n (if (> (mod c q) 0) (inc q) q)]
                  (apply map vector (partition n n (repeat nil) xs)))
          'right (map vec (partition cols cols (repeat nil) xs))))) 
