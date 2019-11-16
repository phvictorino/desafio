<template>
  <div>
    <v-card>
      <v-card-title> </v-card-title>
      <v-card-text>
        <v-row class="mt-3" justify="center">
          <v-btn @click="novaLicitacao" dark color="indigo">Nova Licitação</v-btn>
        </v-row>
        <v-data-table :items="listaLicitacaoes" :headers="headers"> </v-data-table>
      </v-card-text>
    </v-card>
    <v-dialog v-model="dialogFormulario" max-width="800">
      <formulario v-model="licitacaoSelecionada" @saved="saved"></formulario>
    </v-dialog>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  components: {
    formulario: () => import('@/components/FormularioLicitacao.vue'),
  },
  data: () => ({
    headers: [
      {
        text: 'Descrição',
        value: 'descricao',
      },
    ],
    dialogFormulario: false,
    licitacaoSelecionada: {},
  }),
  computed: {
    ...mapGetters('licitacao', ['listaLicitacaoes']),
  },
  mounted() {
    this.listar();
  },
  methods: {
    async listar() {
      this.$store.dispatch('licitacao/buscarTodos');
    },
    novaLicitacao() {
      this.dialogFormulario = true;
    },
    saved() {
      this.dialogFormulario = false;
    },
  },
};
</script>

<style></style>
