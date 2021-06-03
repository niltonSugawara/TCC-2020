package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoServicoRepository extends JpaRepository <TipoServico, Integer> {
}
