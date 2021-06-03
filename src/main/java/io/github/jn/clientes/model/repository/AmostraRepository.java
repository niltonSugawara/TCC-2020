package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.Amostra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmostraRepository extends JpaRepository <Amostra, Integer> {
}
