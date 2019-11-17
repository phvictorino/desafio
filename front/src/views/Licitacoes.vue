<template>
  <div>
    <v-card>
      <v-card-title>
        <h3 class="title">Listagem de licitações</h3>
      </v-card-title>
      <v-card-text>
        <v-data-table
          :items="listaLicitacaoes"
          :headers="headers"
        >
          <template v-slot:item.tipoClassificacao="{item}">
            {{item.tipoClassificacao | transformarTipoClassificacao}}
          </template>
          <template v-slot:item.acoes="{item}">
            <botao-acao-tabela
              icone="mdi-pencil"
              @click="editar(item)"
              texto="Editar"
            />
            <botao-acao-tabela
              icone="mdi-clipboard-list"
              @click="verPropostas(item)"
              texto="Propostas"
            />
          </template>
        </v-data-table>
        <v-row
          class="mt-3"
          justify="center"
        >
          <v-btn
            @click="novaLicitacao"
            dark
            color="indigo"
          >Nova Licitação</v-btn>
        </v-row>
      </v-card-text>
    </v-card>
    <v-dialog
      v-model="dialogFormulario"
      max-width="800"
    >
      <formulario @saved="saved"></formulario>
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
      {
        text: 'Tipo de classificação',
        value: 'tipoClassificacao',
      },
      {
        text: 'Ações',
        value: 'acoes',
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
    editar(licitacao) {
      this.$store.commit('licitacao/alteraLicitacao', licitacao);
      this.dialogFormulario = true;
    },
  },
};
</script>

<style></style>
