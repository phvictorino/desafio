<template>
  <div>
    <v-card>
      <v-card-title>
        <h3 class="title">
          Propostas da Licitação: {{licitacao.descricao}}
        </h3>
      </v-card-title>
      <v-card-text>
        <p class="subtitle">
          Tipo de classificação: {{licitacao.tipoClassificacao | transformarTipoClassificacao}}
        </p>
        <v-data-table
          :items="licitacao.propostas"
          :headers="headers"
        >
          <template v-slot:item.dataCadastro="{item}">
            {{item.dataCadastro | transformarData}}
          </template>
          <template v-slot:item.preco="{item}">
            {{item.preco | transformarMoeda}}
          </template>
          <template v-slot:item.acoes="{item}">
            <botao-acao-tabela
              texto="Editar"
              icone="mdi-pencil"
              @click="editar(item)"
            />
            <botao-acao-tabela
              texto="Excluir"
              icone="mdi-delete"
              @click="excluir(item)"
            />
          </template>
        </v-data-table>
      </v-card-text>
      <v-card-actions class="justify-center">
        <v-btn
          dark
          color="indigo"
          @click="novaProposta"
        >Nova proposta</v-btn>
        <v-btn
          dark
          color="indigo"
          @click="reclassificarPropostas"
        >Reclassificar propostas</v-btn>
        <v-btn
          dark
          color="error"
          @click="$emit('close')"
        >Fechar</v-btn>
      </v-card-actions>
    </v-card>
    <v-dialog
      v-model="dialogFormulario"
      max-width="800"
    >
      <formulario-proposta @close="dialogFormulario = false"></formulario-proposta>
    </v-dialog>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  components: {
    'formulario-proposta': () => import('@/components/FormularioProposta.vue'),
  },
  data: () => ({
    dialogFormulario: false,
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
      {
        text: 'Ações',
        value: 'acoes',
      },
    ],
  }),
  computed: {
    ...mapState('licitacao', ['licitacao']),
  },
  methods: {
    novaProposta() {
      this.$store.commit('proposta/nova');
      this.dialogFormulario = true;
    },
    async reclassificarPropostas() {
      await this.$store.dispatch('licitacao/carregarPropostas');
    },
    editar(proposta) {
      this.$store.commit('proposta/alterarProposta', proposta);
      this.dialogFormulario = true;
    },
    async excluir(proposta) {
      await this.$store.commit('proposta/excluir', proposta);
    },
  },
};
</script>

<style>
</style>
