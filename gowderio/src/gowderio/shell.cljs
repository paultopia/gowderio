(ns gowderio.shell
  (:require [soda-ash.element :as s]
            [goog.events :refer [listen]]
            [reagent.core :refer [atom force-update-all]]))

(def navbar #(gowderio.nav.navbar))
;; this is a dirty circular dependency trick. see https://github.com/shaunlebron/cljs-circular-dependency

(defn loren [reps]
  (apply str (take reps (repeat "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
      eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
      ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
      aliquip ex ea commodo consequat. Duis aute irure dolor in
      reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
      pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
      culpa qui officia deserunt mollit anim id est laborum."))))

(defn shell [label content]
  [:div
   [s/container {:soda {:type :text}}
    [navbar]
    [:h2 "Paul Gowder"]
     [:h3 label]
     content]])

(defn footnote-flag [num ratom text]
  [:sup {:data-tooltip text
         :on-click #(reset! ratom true)}
         (str "(" num ") ")])

(defn close-modal [ratom page]
  (cond
    (= @ratom true)
    (do
      (reset! ratom false)
      (force-update-all))))

(defn modal-content [text ratom page]
  (when @ratom
    (do
      (listen js/window "keypress" #(close-modal ratom page))
      [:div.ui.dimmer.modals.page.transition.visible.active
       {:on-click #(close-modal ratom page)}
       [:div.ui.standard.basic.modal.transition.visible.active.scrolling
        {:on-click #(close-modal ratom page)
         :style {:display "flex"
                 :height "100%"}}
        [s/container
         {:soda {:type :text}
          :style {:display "flex"
                  :align-items "center"
                  :justify-content "center"
                  :height "75%"
                  :font-size "larger"}}
         text]]])))

(defn handle-footnote-key [key-event num page ratom]
  (let [keypress (.-keyCode key-event)]
    (cond
      (and  (= (+ 48 num) keypress) (= page @gowderio.nav.curpage))
      (reset! ratom true))))

(def footnote-counter (atom 0))

(defn footnote [page & text]
  (do
    (swap! footnote-counter inc)
    (let [modal-state (atom false)
          num @footnote-counter]
      (fn [page & text]
        (let [tt (first text) content (apply str text)]
          (listen js/window "keypress" #(handle-footnote-key % num page modal-state))
          [:span
           [footnote-flag num modal-state tt]
           [modal-content content modal-state page]])))))
