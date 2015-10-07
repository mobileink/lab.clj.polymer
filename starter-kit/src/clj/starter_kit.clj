(ns starter-kit
  (:require [clojure.tools.logging :as log :refer [trace debug info]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route :refer [not-found]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.resource :refer [wrap-resource]]
            [polymeraj.hiccup :as poly :refer :all]
    ))
;
(defroutes starter-kit-routes

  (GET "/" []
    (log/trace "route: /")
    (poly/resume starter-kit.home main))

  (route/not-found "Not Found"))
;;;;;;
(def app
  (-> starter-kit-routes
    (wrap-resource "/")
    (wrap-component 'starter-kit.components)
    (wrap-defaults site-defaults)))
