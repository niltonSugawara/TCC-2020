package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository <Tecnico, Integer> {
}
