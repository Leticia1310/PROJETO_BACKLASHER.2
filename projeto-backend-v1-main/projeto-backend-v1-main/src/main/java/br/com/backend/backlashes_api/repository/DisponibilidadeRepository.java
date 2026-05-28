package br.com.backend.backlashes_api.repository;

import br.com.backend.backlashes_api.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

}