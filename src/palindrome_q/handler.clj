(ns palindrome-q.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [palindrome-q.routes [home-route :refer [home-routes]]]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]))

(defroutes app-routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults
   (routes home-routes
           app-routes)
   site-defaults))
