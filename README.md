# barebones

A quick test of b1

## Overview

Created with
```lein new figwheel barebones -- --om```

Our Error

```
Uncaught Error: nth not supported on this type function Boolean() { [native code] }
cljs.core.nth.cljs$core$IFn$_invoke$arity$3 @ core.cljs:1559
cljs$core$nth @ core.cljs:1498b1$layout$histogram$fixed_size_bins @ histogram.cljc?rel=1435855110581:25
b1.layout.histogram.histogram.cljs$core$IFn$_invoke$arity$variadic @ histogram.cljc?rel=1435855110581:64
b1$layout$histogram$histogram @ histogram.cljc?rel=1435855110581:32
b1.charts.histogram.cljs$core$IFn$_invoke$arity$variadic @ charts.cljc?rel=1435855110613:8
b1$charts$histogram @ charts.cljc?rel=1435855110613:6
om.core.root.call.barebones.core.t31509.om$core$IRender$render$arity$1 @ core.cljs?rel=1435855345147:22
om$core$render @ core.cljs?rel=1435855022840:47
om.core.pure_methods.cljs.core.PersistentHashMap.fromArrays.this$ @ core.cljs?rel=1435855022840:394
(anonymous function) @ react.inc.js:6578ReactPerf.measure.wrapper @ react.inc.js:12389
(anonymous function) @ react.inc.js:6120
ReactPerf.measure.wrapper @ react.inc.js:12389
ReactComponent.Mixin._mountComponentIntoNode @ react.inc.js:5162
Mixin.perform @ react.inc.js:15432
ReactComponent.Mixin.mountComponentIntoNode @ react.inc.js:5138
(anonymous function) @ react.inc.js:11269
ReactPerf.measure.wrapper @ react.inc.js:12389
ReactMount.render @ react.inc.js:11338
ReactPerf.measure.wrapper @ react.inc.js:12389
om$dom$render @ dom.cljs?rel=1435855021816:50
om$core$root_$_rootf @ core.cljs?rel=1435855022840:1130
om$core$root @ core.cljs?rel=1435855022840:1190
(anonymous function) @ core.cljs?rel=1435855345147:17
```

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## License

Copyright © 2014 Bruce Durling

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
