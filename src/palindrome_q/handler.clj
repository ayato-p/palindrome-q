(ns palindrome_q.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [immutant.web :as web]
            [palindrome_q.routes [home-route :refer [home-routes]]]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]])
  (:gen-class))

(defroutes app-routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults
   (routes home-routes
           app-routes)
   site-defaults))

(defn -main [& args]
  (web/run app args))
