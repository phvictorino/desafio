import Vue from 'vue';
import VueRouter from 'vue-router';
import Licitacoes from '@/views/Licitacoes.vue';
import Propostas from '@/views/Propostas.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'licitacoes',
    component: Licitacoes,
  },
  {
    path: '/propostas',
    name: 'propostas',
    component: Propostas,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
