(ns starter-kit.components
  (:require [hiccup.page :refer [html5]]
            [polymeraj.hiccup :refer :all]))

(co-fn my-list
  []
  [:link {:rel "import" :href "polymer/polymer/polymer.html"}]
  [:link {:rel "import" :href "styles/shared/style-modules.html"}]
  [:dom-module#my-list
   [:template
    [:style {:include "shared-styles"}]
    [:ul
     [:template {:is "dom-repeat" :items "{{items}}"}
      [:li [:span {:class "paper-font-body1"}"{{item}}"]]]]]])


(defn my-greeting
  []
  [:link {:rel "import" :href "polymer/polymer/polymer.html"}]

  [:dom-module#my-greeting
   [:template
    [:style {:include "shared-styles"}]
    [:style "
      :host {
        display: block;
      }"]

    [:h2 {:class "page-title"} [:span "{{greeting}}"]]
    [:span {:class "paper-font-body2"} "Update text to change the greeting."]
    ;; Listens for "input" event and sets greeting to <input>.value
    [:input.paper-font-body2 {:value "{{greeting::input}}"}]]])
