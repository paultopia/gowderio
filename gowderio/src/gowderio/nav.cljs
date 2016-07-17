(ns gowderio.nav
  (:require [soda-ash.element :as s]
          [reagent.core :as r :refer [render atom]]
          [gowderio.shell :refer [shell footnote-counter]]
          [goog.events :refer [listen]]
          [clojure.string :refer [capitalize]]
          [gowderio.front :refer [home-page law-page research-page data-page comm-page innovation-page]]))

(declare namemap)

(def curpage (atom :home))

(defn load [page]
  (do
    (reset! footnote-counter 0)
    (render [page] (.getElementById js/document "app"))))

(defn navload [name]
  (do
    (reset! curpage name)
    (load (name namemap))))


(defn colorize [name]
  (cond
    (= name @curpage) :red
    :else :black))

(defn get-viewport [] (-> js/document .-documentElement .-clientWidth))

(defn icon-sizer [vp]
  (cond
    (> 650 vp) :tiny
    :else :massive))

(defn icon-spacer [vp]
  (cond
    (> 650 vp) :default
    :else :very))
;; this is repetitive, should refactor.

(defn nomify [nom]
  (let [n (-> nom name capitalize)]
    (str n " (" (first n) ")")))

(defn navitem
  [icon nom]
  [:div.item
   [:span {:data-tooltip (nomify nom)
           :data-position "bottom center"}
   [s/icon {:soda
            {:icon icon
             :color (colorize nom)
             :circular? true
             :inverted? true}
            :on-click #(navload nom)}]]])

;; this is a vicious hack to get floating navbar without too much screwing around with css positioning.

(def scrollpos (atom 0))

(defn update-scroll []
  (reset! scrollpos (.-pageYOffset js/window)))

(defn track-scroll []
  (.addEventListener js/window "scroll" update-scroll))

(defn crazyfloat [sp]
  (cond
    (< sp 30) "static"
    :else "fixed"))

(defn navbar []
  [:div {:style {:position (crazyfloat @scrollpos)}}
   [s/s-list {:soda
              {:horizontal? true
               :selection? true
               :size (icon-sizer (get-viewport))
               :relaxed (icon-spacer (get-viewport))}}
    [navitem :home :home]
    [navitem :legal :law]
    [navitem :book :research]
    [navitem :line-chart :data]
    [navitem :write :communication]
    [navitem :lightning :innovation]]])

(def keymap {104 :home
             72 :home
             108 :law
             76 :law
             114 :research
             82 :research
             100 :data
             68 :data
             99 :communication
             67 :communication
             105 :innovation
             73 :innovation})

(defn handle-key [key-event]
  (let [keypress (.-keyCode key-event)
        match (get keymap keypress)]
    (if match (navload match))))

(defn keynav []
  (listen js/window "keypress" handle-key))

(def namemap
  {:home home-page
   :law law-page
   :research research-page
   :data data-page
   :communication comm-page
   :innovation innovation-page})
