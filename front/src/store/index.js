import Vue from 'vue';
import Vuex from 'vuex';
import licitacao from './licitacao.module';
import proposta from './proposta.module';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    licitacao,
    proposta,
  },
  strict: true,
});
