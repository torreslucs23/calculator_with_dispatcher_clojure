(ns Skeleton
  (:require [Calc]))

(defn invoke [op args]
  (case op
    "add" (apply Calc/add args)
    "sub" (apply Calc/sub args)
    "mult" (apply Calc/mult args)
    "div" (apply Calc/div args)
    (throw (Exception. (str "Invalid operation: " op))))
  )


