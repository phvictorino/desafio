<template>
  <v-card>
    <v-card-title>
      <h3 class="title">Formulário de Proposta</h3>
    </v-card-title>
    <v-card-text>
      <p>Licitação: {{licitacaoSelecionada.descricao}}</p>
      <v-form>
        <v-text-field v-model="fornecedor" label="Fornecedor" />
        <v-text-field v-model="nota" label="Nota" />
        <v-text-field v-model="preco" label="Preço" />
        <p class="label">Data de Cadastro</p>
        <v-row justify="center">
          <v-date-picker v-model="dataCadastro" label="Data Cadastro" />
        </v-row>
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center">
      <v-btn
        dark
        color="indigo"
        @click="salvar"
      >Salvar</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapGetters, mapState } from 'vuex';

export default {
  computed: {
    fornecedor: {
      get() {
        return this.proposta.fornecedor;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', { campo: 'fornecedor', valor: value });
      },
    },
    nota: {
      get() {
        return this.proposta.nota;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', { campo: 'nota', valor: value });
      },
    },
    preco: {
      get() {
        return this.proposta.preco;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', { campo: 'preco', valor: value });
      },
    },
    dataCadastro: {
      get() {
        return this.proposta.dataCadastro;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', { campo: 'dataCadastro', valor: value });
      },
    },
    ...mapGetters('licitacao', ['licitacaoSelecionada']),
    ...mapState('proposta', ['proposta']),
  },
  methods: {
    async salvar() {
      await this.$store.dispatch('proposta/salvar');
      this.$emit('close');
    },
  },
};
</script>

<style>
</style>
