(defproject palindrome_q "0.1.0-SNAPSHOT"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"
            :year 2015
            :key "mit"}
  :description ""
  :url "https://github.com/ayato0211/palindrome_q"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.immutant/immutant "2.0.0"]
                 [compojure "1.3.3"]
                 [ring/ring-defaults "0.1.4"]
                 [enlive "1.1.5"]
                 [prone "0.8.1"]
                 [org.clojars.ayato_p/cljlc "0.1.0-SNAPSHOT"]]
  :plugins [[lein-ring "0.9.3"]
            [lein-immutant "2.0.0"]
            [lein-haml-sass "0.2.7-SNAPSHOT"]]
  :ring {:handler palindrome_q.handler/app}
  :source-paths ["src"]
  :repl-options {:init-ns palindrome_q.repl}
  :scss {:src "resources/sass"
         :output-directory "resources/public/css"
         :output-extension "css"}
  :hooks [leiningen.scss]
  :main palindrome_q.handler
  :uberjar-name "palindrome_q.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]
                                  [ring/ring-devel "1.3.2"]]
                   :source-paths ["env/dev"]
                   :ring {:stacktrace-middleware prone.middleware/wrap-exceptions}}
             :uberjar {:aot [palindrome_q.handler]}})
