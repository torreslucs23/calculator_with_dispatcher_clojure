(ns Proxy
  (:require [tcp-client :as client]))

(defn request [operation args]
  (let [message (str {:operation operation :args args})]
    (client/send-and-receive "localhost" 5000 message)))
