<template>
  <v-card>
    <v-card-title>
      <h3 class="title">Formulário de Proposta</h3>
    </v-card-title>
    <v-card-text>
      <p>Licitação: {{licitacaoSelecionada.descricao}}</p>
      <v-form ref="form">
        <v-text-field
          :rules="[$rules.required]"
          v-model="fornecedor"
          label="Fornecedor"
        />
        <v-text-field
          :rules="[$rules.required]"
          v-model="nota"
          label="Nota"
        />
        <v-text-field
          :rules="[$rules.required]"
          v-model="preco"
          label="Preço"
        />
        <p class="label">Data de Cadastro</p>
        <v-row justify="center">
          <v-date-picker
            :rules="[$rules.required]"
            v-model="dataCadastro"
            label="Data Cadastro"
          />
        </v-row>
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center">
      <v-btn
        dark
        color="error"
        @click="$emit('close');"
      >Fechar</v-btn>
      <v-btn
        dark
        color="indigo"
        @click="salvar"
      >Salvar</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    fornecedor: {
      get() {
        return this.$store.state.proposta.proposta.fornecedor;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', {
          campo: 'fornecedor',
          valor: value,
        });
      },
    },
    nota: {
      get() {
        return this.$store.state.proposta.proposta.nota;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', {
          campo: 'nota',
          valor: value,
        });
      },
    },
    preco: {
      get() {
        return this.$store.state.proposta.proposta.preco;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', {
          campo: 'preco',
          valor: value,
        });
      },
    },
    dataCadastro: {
      get() {
        return this.$store.state.proposta.proposta.dataCadastro;
      },
      set(value) {
        this.$store.commit('proposta/alterarCampo', {
          campo: 'dataCadastro',
          valor: value,
        });
      },
    },
    ...mapGetters('licitacao', ['licitacaoSelecionada']),
  },
  methods: {
    async salvar() {
      if (!this.$refs.form.validate()) return;
      await this.$store.dispatch('proposta/salvar');
      this.$emit('close');
    },
  },
};
</script>

<style>
</style>
