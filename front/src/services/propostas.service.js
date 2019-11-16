import axios from '@/plugins/axios';

const url = 'propostas';

export const buscarTodos = () => axios.get(url);

export const classificar = tipoClassificacao => axios.get(`${url}/classificadas?tipoClassificacao=${tipoClassificacao}`);
