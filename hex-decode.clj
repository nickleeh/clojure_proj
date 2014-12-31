(defn hexify [s]
  (format "%x" (new java.math.BigInteger (.getBytes s))))


(defn unhexify [hex]
  (apply str
         (map 
          (fn [[x y]] (char (Integer/parseInt (str x y) 16))) 
          (partition 2 hex))))


;; Python:
;; 'Clojure'.encode('hex')
;; # ⇒ '436c6f6a757265'
;; '436c6f6a757265'.decode('hex')
;; # ⇒ 'Clojure'

;; ;; Example:
;; (hexify "Clojure")
;; ;; ⇒ "436c6f6a757265"

;; (unhexify "436c6f6a757265")
;; ;; ⇒ "Clojure"
