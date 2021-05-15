package io.github.jn.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 50)
    private Float valor;

    @Column(nullable = false, length = 50)
    private Date data;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;



}
