(defproject dasjboard "0.1.0-SNAPSHOT"
  :description "A sample developer dashboard"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url  "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-devel "1.7.1"]]
  :repl-options {:init-ns dasjboard.core}
  :ring {:handler dasjboard.core/handler}
  :plugins [[lein-ancient "0.6.15"]
            [lein-ring "0.12.5"]])
