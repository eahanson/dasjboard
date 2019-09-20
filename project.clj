(defproject dasjboard "0.1.0-SNAPSHOT"
  :description "A sample developer dashboard"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url  "https://opensource.org/licenses/MIT"}
  :dependencies [[compojure "1.6.1"]
                 [hiccup "2.0.0-alpha2"]
                 [org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-devel "1.7.1"]]
  :main dasjboard.core
  :repl-options {:init-ns dasjboard.core}
  :plugins [[lein-ancient "0.6.15"]])
