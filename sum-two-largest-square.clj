(defn square [x]
  "Takes a number x, return the square of it."
  (* x x))

(defn sum-two-largest-square [& nums]
  "Takes several numbers, return the square sum of the largest two."
  (->> nums
       sort
       (take-last 2)
       (map square)
       (apply +)))
