/* eslint-disable no-shadow */
import { salvar as salvarService, buscarTodos as buscarTodosService } from '@/services/licitacoes.service';

const state = {
  licitacao: {},
  licitacoes: [],
};

const mutations = {
  alterarLicitacoes(state, licitacoes) {
    state.licitacoes = licitacoes;
  },
  alteraLicitacao(state, licitacao) {
    state.licitacao = licitacao;
  },
  incluir(state, licitacao) {
    state.licitacoes.push(licitacao);
  },
};

const actions = {
  async salvar({ commit }, licitacao) {
    const { data } = await salvarService(licitacao);
    commit('alteraLicitacao', data);
    commit('incluir', data);
  },
  async atualizar({ commit }, licitacao) {
    const { data } = await salvarService(licitacao);
    commit('alteraLicitacao', data);
  },
  async buscarTodos({ commit }) {
    const { data } = await buscarTodosService();
    commit('alterarLicitacoes', data);
  },
};

const getters = {
  listaLicitacaoes(state) {
    return state.licitacoes;
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters,
};
