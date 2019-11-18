import axios from '@/plugins/axios';

const url = 'propostas';

export const buscarTodos = () => axios.get(url);

export const classificar = tipoClassificacao => axios.get(`${url}/classificadas?tipoClassificacao=${tipoClassificacao}`);

export const salvar = proposta => axios.post(url, proposta);

export const atualizar = proposta => axios.put(url, proposta);
