import Vue from 'vue'
import App from './App.vue'
import router from './router'
Vue.config.productionTip = false

import axios from "axios"
Vue.prototype.$axios = axios

import Toast from "../public/static/js/toast.js"
Vue.prototype.$toast = Toast

// 解决每次ajax请求，对应的sessionId不一致的问题
axios.defaults.withCredentials = true;

/**
 * axios请求拦截器
 */
axios.interceptors.request.use( (config) => {
  console.log("请求：",config)
  return config
},()=>{})
/**
 * axios返回拦截器
 */
axios.interceptors.response.use( (response) => {
  console.log("返回：", response)
  return response
},()=>{})



new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
