package io.github.jn.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NormaTecnicaDTO {
    private String nome;
    private String descricao;
    private Integer id_ordem_servico;

}
