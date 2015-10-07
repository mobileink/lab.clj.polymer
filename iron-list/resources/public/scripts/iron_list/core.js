// Compiled by ClojureScript 1.7.48 {}
goog.provide('iron_list.core');
goog.require('cljs.core');
cljs.core.enable_console_print_BANG_.call(null);
var main_6728 = document.querySelector("#main");
main_6728.iconForItem = ((function (main_6728){
return (function (item){
if(cljs.core.truth_(item)){
if((item.integer < (50))){
return "star-border";
} else {
return "star";
}
} else {
return "";
}
});})(main_6728))
;

main_6728.addEventListener("dom-change",((function (main_6728){
return (function (){
var ml = document.querySelector("my-list");
return main_6728.items = cljs.core.clj__GT_js.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, ["foo","bar","BAZ","BUZ"], null));
});})(main_6728))
);

window.addEventListener("WebComponentsReady",((function (main_6728){
return (function (){
return null;
});})(main_6728))
);

cljs.core.println.call(null,"registering my-list");

Polymer({"is": "my-list", "properties": {"items": {"type": Array, "notify": true}}});
cljs.core.println.call(null,"Our app is ready to rock!");
