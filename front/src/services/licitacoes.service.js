import axios from '@/plugins/axios';

const url = 'licitacoes';

export const buscarTodos = () => axios.get(`${url}`);

export const salvar = licitacao => axios.post(url, licitacao);

export const atualizar = licitacao => axios.put(url, licitacao);

export const carregarPropostas = idLicitacao => axios.get(`${url}/${idLicitacao}/propostas`);

export const excluir = idLicitacao => axios.delete(`${url}/${idLicitacao}`);
