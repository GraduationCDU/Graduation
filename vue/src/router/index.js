import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);
export default new Router({
	mode: "history", // history 模式去除地址栏 # 号
	routes: [
		{
			// http://127.0.0.1:8081/login
			path: "/",
			name: "主页面",
			component: () => import("@/views/index.vue"),
			meta: { requireAuth: false },
		},
	],
});
