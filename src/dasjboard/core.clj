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

(def application (handler/site routes))

(defn- get-env->int [env-var]
  (->> env-var
       (System/getenv)
       (or "8080")
       (Integer/parseInt)))

(defn -main []
  (let [port (get-env->int "PORT")]
    (jetty/run-jetty application {:port port :join? false})))

(defn -dev-main []
  (let [port (get-env->int "PORT")]
    (jetty/run-jetty (wrap-reload #'application) {:port port :join? false})))
