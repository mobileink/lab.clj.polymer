(ns starter-kit.components
  (:require [hiccup.page :refer [html5]]))

(defn my-list
  []
  [:link {:rel "import" :href "polymer/polymer/polymer.html"}]
  [:link {:rel "import" :href "styles/shared/style-modules.html"}]
  [:dom-module#my-list
   [:template
    [:style {:include "shared-styles"}]
    [:ul
     [:template {:is "dom-repeat" :items "{{items}}"}
      [:li [:span {:class "paper-font-body1"}"{{item}}"]]]]]])
