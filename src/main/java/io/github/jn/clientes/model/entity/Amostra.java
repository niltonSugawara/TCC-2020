package io.github.jn.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Amostra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = true, length = 250)
    private String descricao;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name = "id_tipo_amostra")
    private TipoAmostra tipoAmostra;

    @ManyToOne
    @JoinColumn (name = "id_Status")
    private Status status;

}
