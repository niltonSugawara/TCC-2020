package io.github.jn.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 8)
    private LocalDate data;

    @ManyToOne
    @JoinColumn (name = "id_tecnico")
    private Tecnico tecnico;

}
