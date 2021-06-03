package io.github.jn.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoServicoDTO {

    private String nome;
    private Integer id_ordem_servico;
}
