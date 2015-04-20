(ns palindrome-q.routes.home-route
  (:require [cljlc.core :refer [palindrome?]]
            [clojure.string :as str]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as html]
            [ring.middleware.defaults :refer [site-defaults
                                              wrap-defaults]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn input-form []
  (let [html-form (first ((html/snippet "templates/home/form.html" [:form] [])))
        form-content (:content html-form)
        aff (first (html/html-snippet (anti-forgery-field)))]
    (list (assoc-in html-form [:content]
                    (conj form-content aff)))))

(html/deftemplate home-page "templates/layouts/application.html" []
  [:h1] (html/content "Welcome!!")
  [:div#content] (html/content (input-form)))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/check" [words] (palindrome? words)))
