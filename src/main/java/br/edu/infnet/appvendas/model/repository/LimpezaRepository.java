package br.edu.infnet.appvendas.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvendas.model.domain.Limpeza;

@Repository
public interface LimpezaRepository extends CrudRepository<Limpeza, Integer> {

	Collection<Limpeza> findByFragancia(String fragancia);
}
