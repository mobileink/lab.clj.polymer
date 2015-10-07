(ns iron-list.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.handler.dump :refer [handle-dump]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :as r]
            [ringx.util.http-response :as rx :refer :all]
            [iron-list.hiccup [iron-list :as il]]))

(defroutes app-routes

  (GET "/" []
    (-> (ok (str (il/main-page)))
      (r/content-type "text/html")))

  (route/not-found "Not Found"))

(def app
  (-> app-routes
    (wrap-resource "/")
    (wrap-defaults site-defaults)))
