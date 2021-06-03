package io.github.jn.clientes.model.repository;

import io.github.jn.clientes.model.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository <Orcamento, Integer> {
    @Query( " select o from Orcamento o join o.cliente c where upper( c.nome )" +
            " like upper( :nome )  " )
    List<Orcamento> findAllByNomeClienteAndMes(@Param("nome") String nome);
    }
