
import { createApp } from 'vue'
import App from './App.vue'

import router from "@/router/index.js";//引入路由
import ElementPlus from 'element-plus'//element组件库
import TDesign from 'tdesign-vue-next';//腾讯组件库

import 'element-plus/dist/index.css'
import 'tdesign-vue-next/es/style/index.css';

const app = createApp(App)

const getObjChainingVal = (obj, keyName) => {
    // ...
    return tempObj
}
app.config.globalProperties.getObjChainingVal = getObjChainingVal;
app.config.globalProperties.$website = 'http://localhost:8080';

app.use(router)
app.use(ElementPlus)
app.use(TDesign)

app.mount('#app')
