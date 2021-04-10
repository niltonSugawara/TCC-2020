package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
}
