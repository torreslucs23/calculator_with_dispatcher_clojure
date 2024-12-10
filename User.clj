(ns User
  (:require [Proxy :as Proxy]
            [clojure.string :as str]))

(defn -main [& args]
  (println "Choose operation: add, sub, mult, div")
  (let [op (read-line)]
        (println "Write the arguments separated by spaces")
        (let [args (map read-string (str/split (read-line) #"\s+"))
        response (Proxy/request op args)]
    (println "Response from server:" response))))