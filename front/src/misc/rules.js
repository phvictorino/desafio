import Vue from 'vue';

const rules = {
  required: value => !!value || 'Campo obrigatõrio.',
};

Vue.prototype.$rules = rules;
