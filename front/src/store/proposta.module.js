/* eslint-disable no-shadow */
import * as service from '@/services/propostas.service';

const state = {
  proposta: {},
};

const mutations = {
  alterarCampo(state, { campo, valor }) {
    state.proposta = Object.assign(state.proposta, { [campo]: valor });
  },
  nova(state) {
    state.proposta = {};
  },
  alterarProposta(state, proposta) {
    state.proposta = proposta;
  },
};

const actions = {
  async salvar({ commit, state, rootGetters }) {
    if (!state.proposta.id) {
      state.proposta.licitacao = rootGetters['licitacao/licitacaoSelecionada'].id;
      const { data } = await service.salvar(state.proposta);
      commit('licitacao/adicionarPropostaParaLicitacao', data, { root: true });
    } else {
      const { data } = await service.atualizar(state.proposta);
      commit('licitacao/atualizarPropostaParaLicitacao', { antiga: state.proposta, nova: data }, { root: true });
    }
  },
};

const getters = {};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters,
};
