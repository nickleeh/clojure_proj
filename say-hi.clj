(ns learning.greeting
  (:require [clojure.string :as string]))
(defn say-hi
  "Say hi to zero or more pelple."
  ([] (say-hi "World"))
  ([& names]
   (if (next names)                      ; Determin whether there's one or more arguments.
     (format "Hi, %s, and %s!"
             (string/join ", " (butlast names))
             (last names))               ; Multiple arguments case.
     (format "Hi, %s!" (first names))))) ; Print "Hi, world"
