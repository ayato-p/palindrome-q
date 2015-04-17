(ns palindrome-q.routes.home-route
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as html]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]))

(html/deftemplate home-page "templates/layouts/application.html" []
  [:h1] (html/content "Welcome!!")
  [:div#content] (html/content "Hello!><"))

(defroutes home-routes
  (GET "/" [] (home-page)))
