import Vue from 'vue';
import moment from 'moment';

Vue.filter('transformarTipoClassificacao', (value) => {
  if (!value) return '';
  const map = new Map([
    ['MENOR_PRECO', 'Menor preço'],
    ['NOTA_PRECO', 'Nota preço'],
  ]);
  return map.get(value);
});

Vue.filter('transformarData', value => moment(value).format('DD/MM/YYYY'));

Vue.filter('transformarMoeda', (value) => {
  if (!value) return '';
  return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
});
