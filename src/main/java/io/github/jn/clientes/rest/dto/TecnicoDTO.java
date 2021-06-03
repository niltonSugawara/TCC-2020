package io.github.jn.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TecnicoDTO {
    private String nome;
    private String crq;
    private Integer id_ordem_servico;

}
