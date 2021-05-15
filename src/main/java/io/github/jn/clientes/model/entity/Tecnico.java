package io.github.jn.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String crq;

}
