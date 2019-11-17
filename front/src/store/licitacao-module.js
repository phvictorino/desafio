/* eslint-disable no-shadow */
import * as service from '@/services/licitacoes.service';

const state = {
  licitacao: {
    propostas: [],
  },
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
  alterarCampo(state, { campo, valor }) {
    console.log(campo, valor);
    state.licitacao = Object.assign(state.licitacao, { [campo]: valor });
  },
};

const actions = {
  async salvar({ commit, state }) {
    if (!state.licitacao.id) {
      const { data } = await service.salvar(state.licitacao);
      commit('incluir', data);
    } else {
      const { data } = await service.atualizar(state.licitacao);
      commit('alteraLicitacao', data);
    }
  },
  async buscarTodos({ commit }) {
    const { data } = await service.buscarTodos();
    commit('alterarLicitacoes', data);
  },
  async carregarPropostas({ commit }, licitacao) {
    const { data } = await service.carregarPropostas(licitacao.id);
    commit('alteraLicitacao', data);
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
