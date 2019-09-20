(ns dasjboard.core
  (:require [compojure.core :refer [defroutes GET ANY]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [dasjboard.views.contents :as contents]
            [dasjboard.views.layout :as layout]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defroutes routes
           (GET "/" [] (layout/application "Dasjboard" (contents/index)))
           (route/resources "/")
           (ANY "*" [] (route/not-found (layout/application "Page Not Found" (contents/not-found)))))

(def application (wrap-reload (handler/site routes)))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (jetty/run-jetty application {:port port :join? false})))
