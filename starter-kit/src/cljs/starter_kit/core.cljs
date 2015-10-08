(ns starter-kit.core
  (:require [clojure.browser.repl :as repl]))

(enable-console-print!)

;;(repl/connect "http://localhost:9000/repl")

(def main (.querySelector js/document "#main"))

(set! (.-iconForItem main)
  (fn [item]
    (if item
      (if (< (.-integer item) 50) "star-border" "star")
      "")))

(println "registering my-list")
(js/Polymer
  #js {:is "my-list"
       :properties  #js {:items #js {:type js/Array
                                     :notify true}}})

;; (println "registering my-greeting")
;; (js/Polymer
;;   #js {:is "my-greeting"
;;        :properties  #js {:greeting #js {:type js/String
;;                                         :value "Welcome!"
;;                                         :notivy true}}})

(.addEventListener main "dom-change"
  (fn []
    (println "DOM-CHANGE")
    (let [ml (.querySelector js/document "my-list")]
      (set! (.-items ml) (clj->js
                           ["HTML/Webcomponents as a Clojure language extension!"
                            "Webcomponents as Clojure functions!"
                            "Seamless integration with Clojurescript!"
                            "Plus:"
                            "Responsive Web App boilerplate",
                            "Iron Elements and Paper Elements",
                            "End-to-end Build Tooling (including Vulcanize)",
                            "Unit testing with Web Component Tester",
                            "Routing with Page.js",
                            "Offline support with the Platinum Service Worker Elements"])))))

(.addEventListener js/window "WebComponentsReady"
  (fn []
    ;; imports are loaded and elements have been registered
    (println "WebComponentsReady")
    ;; Middleware
    (let [scrollToTop (fn [ctx, next]
                        (.scrollPageToTop main)
                        (next))]

    ;; Routes
      (js/page "/" scrollToTop (fn [] (set! (.-route main) "home")))

      (js/page "/users" scrollToTop (fn [] (set! (.-route main) "users")))
      (js/page "/users/:name" scrollToTop (fn [data]
                                         (do (set! (.-route main) "user-info")
                                             (set! (.-params main) (.-params data)))))
      (js/page "/contact" scrollToTop (fn [] (set! (.-route main) "contact")))

      ;; add #! before urls
      (js/page #js {:hashbang true})
    )))

;; Close drawer after menu item is selected if drawerPanel is narrow
(set! (.-onDataRouteClick main)
  (fn [] (let [drawerPanel (.querySelector js/document "#paperDrawerPanel")]
           (when (.-narrow drawerPanel)
             (.closeDrawer drawerPanel)))))

(println "setting scrollPageToTop?")
;; Scroll page to top and expand header
(set! (.-scrollPageToTop main)
  (fn [] (let [elt (.getElementById js/document "mainContainer")]
           (set! (.-scrollTop elt) 0))))


(println "Our app is ready to rock!")

