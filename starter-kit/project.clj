(defproject starter-kit "0.1.0-SNAPSHOT"
  :description "Clojure version of Polymer Starter Kit"
  :url "https://github.com/mobileink/lab.clj.polymer"
  :min-lein-version "2.0.0"
  :source-paths ["src/clj" "src/cljc"]
  :dependencies [[org.clojure/clojure "1.7.0"] ;; "1.8.0-master-SNAPSHOT"]
                 [org.clojure/tools.reader "0.10.0-alpha1"]
                 [org.clojure/clojurescript "1.7.48"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [polymeraj "1.1.4-SNAPSHOT"]
                 [ring/ring-core "1.4.0"]
		 [ring/ring-defaults "0.1.5"]
                 [com.cemerick/url "0.1.1"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.slf4j/slf4j-log4j12 "1.7.1"]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jmdk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 ]
  :cljsbuild {
              :builds [{
                        ;; The path to the top-level ClojureScript source directory:
                        :source-paths ["src/cljs"]
                        ;; The standard ClojureScript compiler options:
                        ;; (See the ClojureScript compiler documentation for details.)
                        :compiler {
                                   :output-to "resources/public/scripts/starter_kit.js"
                                   :output-dir "resources/public/scripts/tmp"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.1.0"]]
  :ring {:handler starter-kit/app :port 8087}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
            	              [ring-mock "0.1.5"]]}})
