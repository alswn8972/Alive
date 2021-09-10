import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/startPage.vue";


Vue.use(VueRouter);


const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
];

const router = new VueRouter({
  mode: "history",
  base: "",
  routes,
});


export default router;