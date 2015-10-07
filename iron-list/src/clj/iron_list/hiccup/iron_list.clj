(ns iron-list.hiccup.iron-list
  (:require
   [clojure.pprint :as pp]
   [clojure.tools.logging :as log :only [debug info]]
   [hiccup.page :refer [html5]]))

(defmacro configure-jsvm
  [title & opts]
  `[:head
    [:title ~title]
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport",
            :content
            "width=device-width, minimum-scale=1.0, initial-scale=1, user-scalable=yes"}]
    [:meta {:name "mobile-web-app-capable", :content "yes"}]
    [:meta {:name "apple-mobile-web-app-capable", :content "yes"}]
    [:script {:src "polymer/webcomponentsjs/webcomponents-lite.js"}]
    [:link {:rel "import", :href "elements/elements.html"}]
    ;; [:link {:rel "import", :href "../shared-styles/shared-styles.html"}]
    ;; theme from https://polymerthemes.com/
    ;; [:link {:rel "import", :href "themes/denim/denim.html"}]
    [:link {:rel "import", :href "styles/core.css"}]
    ]
  )

(defn main-page []
  (html5 {:lang ""}

    (configure-jsvm "iron-list demo"
      (:require [style.core]
                [components.core]))

  [:body {:unresolved true}

   [:template#main {:is "dom-bind"}

    [:iron-ajax {:url "data/contacts.json",
                 :last-response "{{data}}",
                 :auto "auto"}]

    [:paper-scroll-header-panel.fit
     {:condenses true
      :keep-condensed-header true}

     [:paper-toolbar.tall
      [:paper-icon-button {:icon "arrow-back", :alt "Back"}]
      [:div.flex]
      [:paper-icon-button {:icon "search", :alt "Search"}]
      [:paper-icon-button {:icon "more-vert", :alt "More options"}]
      [:div.bottom.title "iron-list"]] ;; paper-toolbar.tall

     ;; [:div
     ;;  [:my-list {:items "{{items}}"}]]

     [:iron-list
      {:items "[[data]]", :as "item"}
      [:template
       [:div
        [:div.item
         {:tabindex "0"}
         [:img.avatar {:src "[[item.image]]"}]
         [:div.pad
          [:div.primary "[[item.name]]"]
          [:div.secondary "[[item.shortText]]"]
          [:div.secondary.dim "[[item.longText]]"]]
         [:iron-icon {:icon$ "[[iconForItem(item)]]"}]]]]] ;; iron-list
     ] ;; :paper-scroll-header-panel.fit
    ] ;; template
   [:script {:src "scripts/iron-list.js"}]
   ;; [:script {:src "scripts/js/core.js"}]
   ] ;; body
  ))
