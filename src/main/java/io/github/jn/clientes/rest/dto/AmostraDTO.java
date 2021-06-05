package io.github.jn.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmostraDTO {
    private String nome;
    private String descricao;
    private Integer id_cliente;
    private Integer id_status;
    private  Integer id_tipo_amostra;


}
