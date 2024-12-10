(ns Dispatcher
  (:require [Skeleton :as skeleton]))

(defn dispatch [request]
  (let [{:keys [operation args]} (read-string request)]
    (try
      (pr-str {:result (skeleton/invoke operation args)})
      (catch Exception e
        (pr-str {:error (.getMessage e)})))))
