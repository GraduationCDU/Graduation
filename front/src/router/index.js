import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
	mode: "history", // history 模式去除地址栏 # 号
	routes: [
		{
			// http://127.0.0.1:8080/
			path: "/",
			name: "主页",
			component: () => import("@/components/Course/index.vue"),
            meta: { requireAuth: false },
		},
		{
			// http://127.0.0.1:8081/login
			path: "/search",
			name: "搜索",
			component: () => import("@/components/Course/Search.vue"),
			meta: { requireAuth: false },
		},
		{
			// http://127.0.0.1:8081/login
			path: "/list",
			name: "列表",
			component: () => import("@/components/Course/List.vue"),
			meta: { requireAuth: false },
		},
		{
			// http://127.0.0.1:8081/login
			path: "/login",
			name: "登录",
			component: () => import("@/components/Login.vue"),
			meta: { requireAuth: false },
		}
	],
});
