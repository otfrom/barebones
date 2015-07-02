(ns ^:figwheel-always barebones.core
    (:require [om.core :as om :include-macros true]
              [om.dom :as dom :include-macros true]
              [b1.charts :as c]
              [b1.svg :as s]))

(enable-console-print!)

(def data (take 100 (repeatedly rand)))

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(om/root
 (fn [data owner]
   (reify om/IRender
     (render [_]
             (dom/h1 nil (:text data))
             (-> (c/histogram data :x-axis [0 1] :bins 20)
                 (s/as-svg :width 500 :height 200)))))
 app-state
 {:target (. js/document (getElementById "app"))})

;; Created with
;; lein new figwheel barebones -- --om

;; Our Error
;;
;; Uncaught Error: nth not supported on this type function Boolean() { [native code] }
;; cljs.core.nth.cljs$core$IFn$_invoke$arity$3 @ core.cljs:1559
;; cljs$core$nth @ core.cljs:1498b1$layout$histogram$fixed_size_bins @ histogram.cljc?rel=1435855110581:25
;; b1.layout.histogram.histogram.cljs$core$IFn$_invoke$arity$variadic @ histogram.cljc?rel=1435855110581:64
;; b1$layout$histogram$histogram @ histogram.cljc?rel=1435855110581:32
;; b1.charts.histogram.cljs$core$IFn$_invoke$arity$variadic @ charts.cljc?rel=1435855110613:8
;; b1$charts$histogram @ charts.cljc?rel=1435855110613:6
;; om.core.root.call.barebones.core.t31509.om$core$IRender$render$arity$1 @ core.cljs?rel=1435855345147:22
;; om$core$render @ core.cljs?rel=1435855022840:47
;; om.core.pure_methods.cljs.core.PersistentHashMap.fromArrays.this$ @ core.cljs?rel=1435855022840:394
;; (anonymous function) @ react.inc.js:6578ReactPerf.measure.wrapper @ react.inc.js:12389
;; (anonymous function) @ react.inc.js:6120
;; ReactPerf.measure.wrapper @ react.inc.js:12389
;; ReactComponent.Mixin._mountComponentIntoNode @ react.inc.js:5162
;; Mixin.perform @ react.inc.js:15432
;; ReactComponent.Mixin.mountComponentIntoNode @ react.inc.js:5138
;; (anonymous function) @ react.inc.js:11269
;; ReactPerf.measure.wrapper @ react.inc.js:12389
;; ReactMount.render @ react.inc.js:11338
;; ReactPerf.measure.wrapper @ react.inc.js:12389
;; om$dom$render @ dom.cljs?rel=1435855021816:50
;; om$core$root_$_rootf @ core.cljs?rel=1435855022840:1130
;; om$core$root @ core.cljs?rel=1435855022840:1190
;; (anonymous function) @ core.cljs?rel=1435855345147:17


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
