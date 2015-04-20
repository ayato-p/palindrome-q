(ns palindrome-q.repl
  (:require [immutant.web :as web]
            [palindrome-q.handler :refer [app]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.file :refer [wrap-file]]))

(defonce server (atom nil))

(defn get-handler []
  (-> #'app
      (wrap-reload "resources")
      (wrap-file "resources")
      (wrap-file-info)))

(defn start-server [& port]
  (let [port (if port (Integer/parseInt port) 3000)]
    (reset! server
            (web/run (get-handler) :port port))))

(defn stop-server []
  (web/stop @server)
  (reset! server nil))

(defn restart-server [& port]
  (do (stop-server)
      (apply start-server port)))
