(defproject iron-list "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :source-paths ["src/clj" "src/cljc"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [org.clojure/tools.logging "0.3.1"]
                 [compojure "1.4.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [metosin/ringx-http-response "0.6.5"]
                 [polymeraj "1.1.4-SNAPSHOT"]]
  :cljsbuild {
              :builds [{
                        ;; The path to the top-level ClojureScript source directory:
                        :source-paths ["src/cljs"]
                        ;; The standard ClojureScript compiler options:
                        ;; (See the ClojureScript compiler documentation for details.)
                        :compiler {
                                   :output-to "resources/public/scripts/iron-list.js"
                                   :output-dir "resources/public/scripts"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.1.0"]]
  :ring {:handler iron-list.handler/app
         :port 8087}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
