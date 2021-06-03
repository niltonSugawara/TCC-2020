package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository <Status, Integer> {
}
