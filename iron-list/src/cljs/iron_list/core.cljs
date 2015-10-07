(ns iron-list.core)

(enable-console-print!)

(let [main (.querySelector js/document "#main")]

    (set! (.-iconForItem main)
      (fn [item]
        (if item
          (if (< (.-integer item) 50) "star-border" "star")
          "")))

    (.addEventListener main "dom-change"
      (fn []
        (let [ml (.querySelector js/document "my-list")]
          (set! (.-items main) (clj->js ["foo", "bar", "BAZ", "BUZ"])))))

    (.addEventListener js/window "WebComponentsReady"
      (fn []
	;; imports are loaded and elements have been registered
        ))

    (println "registering my-list")
    (js/Polymer
      #js {:is "my-list"
           :properties  #js {:items #js {:type js/Array
                                         :notify true}}})
    )

(println "Our app is ready to rock!")

