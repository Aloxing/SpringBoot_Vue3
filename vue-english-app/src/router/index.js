import { createRouter, createWebHistory } from 'vue-router';
import AloxingView from "@/views/AloxingView.vue"
import LoginView from "@/login/LoginView.vue"
import axios from 'axios'

const routes = [
    {path: '/',component: LoginView,name: 'LoginView'},
    {path: '/main',component: AloxingView,name: 'AloxingView',
        beforeEnter: (to, from, next) => {
            const token = window.localStorage.getItem('token_key');
            if(!token){
                next({path:'/'})
                return
            }
            axios.get("http://localhost:8080"+'/api/aloxing/login/token',{params:{ token }}).then(res=>{
                if(res.data.code===1){
                    next();
                }else{
                    window.localStorage.removeItem('token_key');
                    next('/');
                }
            }).catch(err=>{
                console.log(err)
                window.localStorage.removeItem('token_key');
                next('/');
            })
        }
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes: routes
});

// 在每次导航前执行
// router.beforeEach((to, from, next) => {
//     const token = window.localStorage.getItem('token_key');
//     if(!token){
//         next({path:'/'})
//         return
//     }
//     axios.get("http://localhost:8080"+'/api/aloxing/login/token',{params:{ token }}).then(res=>{
//         if(to.name !== 'Login' && !isAuthenticated && res.data.code===1){
//             next();
//         }else{
//             window.localStorage.removeItem('token_key');
//             next('/');
//         }
//     }).catch(err=>{
//         console.log(err)
//         window.localStorage.removeItem('token_key');
//         next('/');
//     })
// });

export default router;