package io.github.jn.clientes.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OrcamentoDTO {
    private String nome;
    private String valor;
    private String descricao;
    private String data;
    private Integer id_cliente;
}
