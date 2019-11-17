import Vue from 'vue';
import VueRouter from 'vue-router';
import Licitacoes from '@/views/Licitacoes.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'licitacoes',
    component: Licitacoes,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
