(ns word-frequency
  (:use [clojure.string :as str :only [lower-case]]))

(def fname "c:/Users/Nick/Downloads/sample_file.txt")

(defn read-lines [filename]
  "Read a file, return a sequence of lines."
  (with-open [rdr (clojure.java.io/reader filename)]
    (doall (line-seq rdr))))

(defn get-frequency-list [file-name]
  "Given a file, return the words frequency list"
  (let [lines (read-lines file-name)]
    (->> (str lines)
         (re-seq #"\w+")
         (map str/lower-case)
         frequencies)))

(def frequency-list (get-frequency-list fname))

(defn get-most-common [n]
  "Given a word frequency list, return the most n common words (with counts)."
  (->> frequency-list
       (sort-by val >)
       (take n)))

(get-most-common 10)
;;=> (["the" 20005] ["of" 11038] ["and" 6524] ["in" 5659] ["to" 5387] ["a" 3810] ["was" 2565] ["by" 1922] ["for" 1773] ["that" 1567])

;; Look up frequency for a specific word:
(frequency-list "the") ;=> 20005

;; Look up frequencies for a list of words:
(select-keys frequency-list ["history" "the" "best"])
;;=> {"history" 152, "the" 20005, "best" 26}
