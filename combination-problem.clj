(def number-list [3, 4, 5, 6, 7, 8, 9, 10])
(def V 30)

(defn solute-combination-proble []
  "Finds the number of distinct subsets of size 4 that sum up to V"
  (require '[clojure.math.combinatorics :as combo])
  (combo/combinations number-list 4)
  (->> groups
       (map (partial reduce +))
       (filter #(== V %))
       (count)))


(ns example.solve
  (:require [clojure.math.combinatorics :as combo]))

(defn solve
  "Finds the distinct subsets of size 4 that sum up to V"
  [s n v]
  (filter (comp (partial = v)
                (partial reduce +))
          (combo/combinations s n)))
