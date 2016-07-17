(set-env!
 :source-paths #{"src/cljs"}

 :dependencies '[[adzerk/boot-cljs "1.7.228-1"]
                 [org.clojure/clojurescript "1.9.92"]
                 [reagent "0.6.0-rc"]
                 [soda-ash "0.1.0-beta"]
                 [cljsjs/fastclick "1.0.6-0"]]
)

(require '[adzerk.boot-cljs :refer [cljs]])


