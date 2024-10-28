package br.com.fiap.Prova2.repositorios;

import br.com.fiap.Prova2.model.BrinquedoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrinquedoRepositorio  extends JpaRepository<BrinquedoModel, UUID> {
}
