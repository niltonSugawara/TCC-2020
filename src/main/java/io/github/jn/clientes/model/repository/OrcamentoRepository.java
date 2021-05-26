package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository <Orcamento, Integer> {
}
