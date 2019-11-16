import Vue from 'vue';
import Vuex from 'vuex';
import licitacao from './licitacao-module';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    licitacao,
  },
  strict: true,
});
