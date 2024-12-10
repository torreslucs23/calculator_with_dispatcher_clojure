(ns tcp-server
  (:require [Dispatcher :as dispatcher])
  (:import (java.net ServerSocket)))

(defn handle-client [client-socket]
  (with-open [in (java.io.BufferedReader. (java.io.InputStreamReader. (.getInputStream client-socket)))
              out (java.io.PrintWriter. (.getOutputStream client-socket) true)]
    (let [request (.readLine in)
          response (dispatcher/dispatch request)]
      (.println out response))))

(defn start-server [port]
  (let [server-socket (ServerSocket. port)]
    (println (str "Server started on port " port))
    (while true
      (let [client-socket (.accept server-socket)]
        (future (handle-client client-socket))))))

(defn -main [& args]
  (let [port (if (not-empty args)
               (Integer/parseInt (first args))
               5000)] 
    (start-server port)))
