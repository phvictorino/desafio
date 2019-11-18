/* eslint-disable no-shadow */
import * as service from '@/services/licitacoes.service';

const state = {
  licitacao: {
    propostas: [],
  },
  licitacoes: [],
};

const mutations = {
  nova(state) {
    state.licitacao = {};
  },
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
    state.licitacao = Object.assign(state.licitacao, { [campo]: valor });
  },
  adicionarPropostaParaLicitacao(state, proposta) {
    state.licitacao.propostas.push(proposta);
  },
  atualizarPropostaParaLicitacao(state, { antiga, nova }) {
    const index = state.licitacao.propostas.indexOf(antiga);
    state.licitacao.propostas.splice(index, 1, nova);
  },
  removerLicitacao(state, licitacao) {
    const index = state.licitacoes.indexOf(licitacao);
    state.licitacoes.splice(index, 1);
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
  async carregarPropostas({ commit, state }) {
    const { data } = await service.carregarPropostas(state.licitacao.id);
    commit('alteraLicitacao', data);
  },
  async excluir({ commit }, licitacao) {
    await service.excluir(licitacao.id);
    commit('removerLicitacao', licitacao);
  },
};

const getters = {
  listaLicitacaoes(state) {
    return state.licitacoes;
  },
  licitacaoSelecionada(state) {
    return state.licitacao;
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters,
};
