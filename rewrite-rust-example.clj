(def  noms ["Tim", "Eston", "Aaron", "Ben"])
(doseq [i (take-nth 2 (rest noms))]
  (future (println i "says hello from a lightweight thread!")))
