package br.com.azi.challenge.repository;

import br.com.azi.challenge.model.Proposta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropostaRepository extends MongoRepository<Proposta, String> {
}
