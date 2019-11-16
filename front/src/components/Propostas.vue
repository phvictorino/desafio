<template>
  <v-card>
    <v-data-table :items="propostas" :headers="headers"> </v-data-table>
  </v-card>
</template>

<script>
import { buscarTodos } from '@/services/propostas.service';

export default {
  data: () => ({
    propostas: [],
    headers: [
      {
        text: 'Fornecedor',
        value: 'fornecedor',
      },
    ],
  }),
  mounted() {
    this.listar();
  },
  methods: {
    async listar() {
      const { data } = await buscarTodos();
      this.propostas = data;
    },
  },
};
</script>

<style></style>
