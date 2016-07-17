(ns stdio.core
  (:require
   [stdio.nav :refer [load keynav track-scroll]]
   [stdio.front :refer [home-page]]
   [cljsjs.fastclick]))

(js/FastClick.attach (.. js/document -body))

;; -------------------------
;; Initialize page

(defn mount-root [] (load home-page))

(defn init! []
  (mount-root))

(keynav)
(track-scroll)
