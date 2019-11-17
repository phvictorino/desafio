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
      <formulario @saved="dialogFormulario = false"></formulario>
    </v-dialog>
    <v-dialog
      v-model="dialogPropostas"
      max-width="800"
    >
      <propostas @close="dialogPropostas = false" />
    </v-dialog>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  components: {
    formulario: () => import('@/components/FormularioLicitacao.vue'),
    propostas: () => import('@/components/Propostas.vue'),
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
    dialogPropostas: false,
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
      this.$store.commit('licitacao/nova');
      this.dialogFormulario = true;
    },
    editar(licitacao) {
      this.$store.commit('licitacao/alteraLicitacao', licitacao);
      this.dialogFormulario = true;
    },
    async verPropostas(licitacao) {
      this.$store.commit('licitacao/alteraLicitacao', licitacao);
      await this.$store.dispatch('licitacao/carregarPropostas');
      this.dialogPropostas = true;
    },
    novaProposta() {
      this.dialogFormularioProposta = true;
    },
  },
};
</script>

<style></style>
