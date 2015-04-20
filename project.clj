
(defproject palindrome-q "0.1.0-SNAPSHOT"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"
            :year 2015
            :key "mit"}
  :description ""
  :url "https://github.com/ayato0211/palindrome-q"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.immutant/immutant "2.0.0-beta3"]
                 [compojure "1.3.3"]
                 [ring/ring-defaults "0.1.4"]
                 [enlive "1.1.5"]
                 [prone "0.8.1"]
                 [org.clojars.ayato_p/cljlc "0.1.0-SNAPSHOT"]]
  :plugins [[lein-ring "0.9.3"]
            [lein-haml-sass "0.2.7-SNAPSHOT"]
            ;; [lein-sass "0.3.0"]
            ]
  :ring {:handler palindrome-q.handler/app}
  :scss {:src "resources/sass"
         :output-directory "resources/public/css"
         :output-extension "css"}
  :hooks [leiningen.scss]
  :profiles
  {:dev
   {:dependencies [[javax.servlet/servlet-api "2.5"]
                   [ring-mock "0.1.5"]
                   [ring/ring-devel "1.3.2"]]
    :ring {:stacktrace-middleware prone.middleware/wrap-exceptions}}

   :production
   {}})
