(ns starter-kit.home
  (:require [polymeraj.hiccup :refer :all]
            [clojure.pprint :as pp]
            [clojure.tools.logging :as log :refer [debug info]]
            [starter-kit.components :refer :all]
        ))

(co-ns
  "Polymeraj Starter Kit"
  (:require[polymer.iron :as iron :refer [ajax flex-layout icons list pages selector]]
           [polymer.paper :as paper
            :refer [button drawer-panel icon-button item
                    material menu scroll-header-panel
                    styles toolbar]]
           [starter-kit.components [my-list my-greeting]]
           ;; to use the html versions:
           ;; [components.my-list :html  "components/my-list/my-list.html"]
           ;; [components.my-greeting :html  "components/my-greeting/my-greeting.html"]
           [visionmedia.page :js "scripts/lib/page/page.js"]
            ))

;; (log/trace "HEADER: ")
;; (pp/pprint starter-kit.home/page)

(defn home-section
  []
  [:section {:data-route "home"}

   [:paper-material {:elevation "1"}
    [:my-greeting]

    [:p {:class "paper-font-subhead"} "You now have:"]
    [:my-list]

    [:p {:class "paper-font-body2"}
     "Looking for more Web App layouts? Check out our:"
     [:a {:href "https://github.com/PolymerElements/app-layout-templates"} "layouts"]
     "collection. You can also "
     [:a {:href "http://polymerelements.github.io/app-layout-templates/"} "preview" ] "them live."]]  ;;</paper-material>

   [:paper-material {:elevation "1"}
    [:p {:class "paper-font-body2"}"This is another card."]
    ]  ;;</paper-material>

   [:paper-material {:elevation "1" :class "paper-font-body2"}
    [:h1 {:id "license"}"License"]
    [:p "Everything in this repo is BSD style license unless otherwise specified."]
    [:p "Copyright (c) 2015 The Polymer Authors. All rights reserved."]
    [:p "Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:"]
    [:u
     [:li "Redistributions of source code must retain the above copyright
             notice, this list of conditions and the following disclaimer."]
     [:li "Redistributions in binary form must reproduce the above
             copyright notice, this list of conditions and the following disclaimer
             in the documentation and/or other materials provided with the
             distribution."]
     [:li "Neither the name of Google Inc. nor the names of its
             contributors may be used to endorse or promote products derived from
             this software without specific prior written permission."]
     ]  ;;</ul>
    [:p "THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS &quot;AS IS&quot; AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE."]
    ]  ;;</paper-material>

   ]  ;;</section>
  )

(defn main
  []
  [:body {:unresolved true :class "fullbleed layout vertical"}

    [:template#main {:is "dom-bind"}

     [:paper-drawer-panel#paperDrawerPanel
      [:paper-scroll-header-panel {:drawer true :fixed true}
       [:paper-toolbar#drawerToolbar
        [:span {:class "paper-font-title"} "Menu"]]
       ;; Drawer Content
       [:paper-menu {:class "list" :attr-for-selected "data-route" :selected "[[route]]"}
        [:a {:data-route "home" :href "/" :on-click "onDataRouteClick"}
         [:iron-icon {:icon "home"}]  ;; </iron-icon>
         [:span "Home"]]

         [:a {:data-route "users" :href "/users" :on-click "onDataRouteClick"}
          [:iron-icon {:icon "info"}]  ;;</iron-icon>
          [:span "Users"]]

         [:a {:data-route "contact" :href "/contact" :on-click "onDataRouteClick"}
          [:iron-icon {:icon "mail"}]  ;;</iron-icon>
          [:span "Contact"]]]  ;; </paper-menu>
       ]  ;;</paper-scroll-header-panel>

      "<!-- Main Area -->"
     [:paper-scroll-header-panel {:main true :condenses true :keep-condensed-header true}

       "<!-- Main Toolbar -->"
      [:paper-toolbar {:id "mainToolbar" :class "tall"}
       [:paper-icon-button {:id "paperToggle" :icon "menu" :paper-drawer-toggle true}]
       [:span {:class "flex"}]

       "<!-- Toolbar icons -->"
       [:paper-icon-button {:icon "refresh"}]
       [:paper-icon-button {:icon "search"}]

       "<!-- Application name -->"
       [:div {:class "middle middle-container center horizontal layout"}
        [:div {:class "app-name"}"Polymeraj Starter Kit"]]

       "<!-- Application sub title -->"
       [:div {:class "bottom bottom-container center horizontal layout"}
        [:div {:class "bottom-title paper-font-subhead"}
         "The future of the web today - is Clojure!"]]]

       "<!-- Main Content -->"

       [:div {:class "content"}
        [:iron-pages {:attr-for-selected "data-route" :selected "{{route}}"}

         (home-section)

         [:section {:data-route "users"}
          [:paper-material {:elevation "1"}
           [:h2 {:class "page-title"}"Users"]
           [:p "This is the users section"]
           [:a {:href "/users/Rob"}"Rob"]
           ]  ;;</paper-material>
          ]  ;;</section>

         [:section {:data-route "user-info"}
          [:paper-material {:elevation "1"}
           [:h2 {:class "page-title"}
            "User:"[:span "{{params.name}}"]
            ]  ;;</h2>
           [:div "This is " [:span "{{params.name}}" ] "'s section"]
           ]  ;;</paper-material>
         ]  ;;</section>

         [:section {:data-route "contact"}
          [:paper-material {:elevation "1"}
           [:h2 {:class "page-title"}"Contact"]
           [:p "This is the contact section"]
           ]  ;;</paper-material>
          ]  ;;</section>

         ]  ;; </iron-pages>
        ]  ;;</div>
      ]  ;;</paper-scroll-header-panel>
      ]  ;;</paper-drawer-panel>
     ] ;; template
   ;; FIXME:  have polymeraj/resume insert this automagically?
    [:script {:src "scripts/starter_kit.js"}]
    "<!-- endbuild-->"
   ]  ;;</body>

  )  ;;main
