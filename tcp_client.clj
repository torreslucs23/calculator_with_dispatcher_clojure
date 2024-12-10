(ns tcp-client
  (:import (java.net Socket)
           (java.io PrintWriter BufferedReader InputStreamReader)))

(defn send-and-receive [host port message]
  (with-open [socket (Socket. host port)
              out (PrintWriter. (.getOutputStream socket) true)
              in (BufferedReader. (InputStreamReader. (.getInputStream socket)))]
    ;; send message
    (.println out message)
    ;; receive response
    (.readLine in)))