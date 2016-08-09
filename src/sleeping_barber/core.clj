(ns sleeping-barber.core
  (:gen-class)
  (:require [clojure.core.async :as a]))

(defn -main [& args]
  (let [customers (atom 0)
        haircuts (atom 0)
        chairs (a/chan (a/dropping-buffer 3))]

    ;; customers
    (a/go-loop []
      (a/>! chairs (swap! customers inc))
      (a/<! (a/timeout (+ 10 (rand-int 21))))
      (recur))

    ;; the barber
    (a/go-loop [customer (a/<! chairs)]
      (a/<! (a/timeout 20))
      (swap! haircuts inc)
      (recur (a/<! chairs)))

    (Thread/sleep 10000)

    ;; summary
    (println "total haircuts:" @haircuts)
    (println "total customers:" @customers)))
