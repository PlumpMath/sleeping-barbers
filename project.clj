(defproject sleeping-barber "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha10"]
                 [org.clojure/core.async  "0.2.385"]]
  :main ^:skip-aot sleeping-barber.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
