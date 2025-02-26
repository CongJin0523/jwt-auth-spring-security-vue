import { createRouter, createWebHistory } from 'vue-router'
import {authorized} from "@/net/index.js";

const router = createRouter( {
    history:createWebHistory(import.meta.env.BASE_URL),
    routes:[
        {
            path:'/',
            name:'home',
            component: () => import('@/views/Home.vue'),
            children:[
                {
                    path: '', name: 'home-login', component: () => import('@/views/home/Login.vue')
                },
                {
                    path:'register', name: 'home-register', component: () => import('@/views/home/register.vue'),
                },
                {
                    path:'reset', name:'home-reset', component: () => import('@/views/home/reset.vue')
                }
            ]
        },
        {
            path:'/index',
            name: 'index',
            component: () => import('@/views/index.vue')
        }

    ]
})
router.beforeEach((to, from, next) => {
    const isAuthorized = authorized();
    if (to.name.startsWith('home') && isAuthorized) {
        next('/index');
    } else if (to.fullPath.startsWith('/index') && !isAuthorized) {
        next('/');
    } else {
        next();
    }
})
export default router