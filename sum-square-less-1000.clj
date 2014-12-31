(defn sum-square-less-1000 []
  "Find the sum of all the squared odd numbers under 1000
"
  (->> (range)
       (map (fn [n] (* n n)))
       (take-while #(> 1000 %))
       (filter odd?)
       (reduce +)))
