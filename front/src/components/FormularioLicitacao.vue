<template>
  <v-card>
    <v-card-title>
      <h3 class="title">Formulário de Licitação</h3>
    </v-card-title>
    <v-card-text>
      <v-form>
        <v-row>
          <v-col cols="12">
            <v-text-field
              v-model="licitacao.descricao"
              label="Descrição"
            />
          </v-col>
          <v-col cols="12">
            <v-select
              label="Tipo de Classificação"
              :items="tipos"
              v-model="licitacao.tipoClassificacao"
            />
          </v-col>
        </v-row>
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center">
      <v-btn dark color="indigo" @click="salvar">Salvar</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  data: () => ({
    tipos: [
      { text: 'Menor Preço', value: 'MENOR_PRECO' },
      { text: 'Nota Preço', value: 'NOTA_PRECO' },
    ],
    licitacao: {},
  }),
  mounted() {
    this.licitacao = Object.assign({}, this.$store.state.licitacao.licitacao);
  },
  methods: {
    async salvar() {
      if (this.licitacao.id) {
        await this.$store.dispatch('licitacao/atualizar', this.licitacao);
      } else {
        await this.$store.dispatch('licitacao/salvar', this.licitacao);
      }
      this.$emit('saved');
    },
  },
};
</script>

<style>
</style>
