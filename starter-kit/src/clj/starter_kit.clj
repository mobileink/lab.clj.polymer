(ns starter-kit
  (:require [clojure.tools.logging :as log :refer [trace debug info]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route :refer [not-found]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.resource :refer [wrap-resource]]
            [miraj.core :as miraj :refer :all]
    ))

(defroutes starter-kit-routes

  (GET "/" []
    (log/trace "route: /")
    ;; Note: we do not :require starter-kit, because it is a co-namespace
    (miraj/resume starter-kit.home/main))
;
  (route/not-found "Not Found"))
;;;;;;
(def app
  (-> starter-kit-routes
    (wrap-resource "/")
    ;; wrap-reload
    ;; wrap-params
    (miraj/wrap-component 'starter-kit.components)
    ;; wrap-keyword-params
    ;; (wrap-defaults site-defaults)
    ))
