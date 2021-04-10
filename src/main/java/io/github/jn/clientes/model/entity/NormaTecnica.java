package io.github.jn.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class NormaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 10)
    private String codigo;

    @Column(nullable = false, length = 250)
    private String descricao;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;

}
