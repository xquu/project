/*
 * 主页路由
 */
// Vue and Vue Router
import Vue from 'vue'
import Router from 'vue-router'
const Login = () => import("@/views/login.vue")
const Admin = () => import("@/views/admin.vue")
const Welcome = () => import("@/views/admin/welcome.vue")
import Chapter from "../views/admin/chapter"
//import Admin from "@/views/admin.vue"
// Register Vue Router
Vue.use(Router)

// Router Configuration
export default new Router({
    mode: 'history',
    routes: [{
            path: "*",
            redirect: "/login",
        }, {
            path: "",
            redirect: "/login",
        }, {
            path: "/login",
            component: Login
        }, {
            path: "/admin",
            component: Admin,
            children:[{
                path: "welcome",
                component: Welcome
            },{
                path: "chapter",
                component: Chapter
            }]
        }
    ]
})
