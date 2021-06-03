package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository <OrdemServico, Integer> {
}
