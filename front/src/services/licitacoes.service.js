import axios from '@/plugins/axios';

const url = 'licitacoes';

export const buscarTodos = () => axios.get(`${url}`);

export const salvar = licitacao => axios.post(url, licitacao);
