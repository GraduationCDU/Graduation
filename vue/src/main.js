import Vue from 'vue'
import App from './App.vue'
// 引入 vue-router 及路由配置
import Router from "vue-router";
import router from "./router";
Vue.use(Router);





new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
