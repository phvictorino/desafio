import Vue from 'vue';

Vue.filter('transformarTipoClassificacao', (value) => {
  if (!value) return '';
  const map = new Map([
    ['MENOR_PRECO', 'Menor preço'],
    ['NOTA_PRECO', 'Nota preço'],
  ]);
  return map.get(value);
});
