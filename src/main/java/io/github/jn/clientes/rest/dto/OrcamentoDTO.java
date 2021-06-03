package io.github.jn.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrcamentoDTO {
    private String nome;
    private String valor;
    private String descricao;
    private String data;
    private Integer id_cliente;
}
