<template>
  <v-card>
    <v-data-table :items="licitacao.propostas" :headers="headers">

    </v-data-table>
  </v-card>
</template>

<script>
import { mapState } from 'vuex';

export default {
  data: () => ({
    headers: [
      {
        text: 'Fornecedor',
        value: 'fornecedor',
      },
      {
        text: 'Nota',
        value: 'nota',
      },
      {
        text: 'Preço',
        value: 'preco',
      },
      {
        text: 'Data cadastro',
        value: 'dataCadastro',
      },
      {
        text: 'Classificação',
        value: 'classificacao',
      },
    ],
  }),
  computed: {
    ...mapState('licitacao', ['licitacao']),
  },
};
</script>

<style>

</style>
