package br.com.azi.challenge.repository;

import br.com.azi.challenge.model.Licitacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LicitacaoRepository extends MongoRepository<Licitacao, String> {
}