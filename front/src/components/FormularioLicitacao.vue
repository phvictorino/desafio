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
              v-model="value.descricao"
              label="Descrição"
            />
          </v-col>
          <v-col cols="12">
            <v-select
              label="Tipo de Classificação"
              :items="tipos"
              v-model="value.tipoClassificacao"
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
  props: {
    value: {
      type: Object,
      default: () => {},
    },
  },
  data: () => ({
    tipos: [
      { text: 'Menor Preço', value: 'MENOR_PRECO' },
      { text: 'Nota Preço', value: 'NOTA_PRECO' },
    ],
  }),
  methods: {
    async salvar() {
      const licitacaoSalva = await this.$store.dispatch('licitacao/salvar', this.value);
      this.$emit('input', licitacaoSalva);
    },
  },
};
</script>

<style>
</style>
