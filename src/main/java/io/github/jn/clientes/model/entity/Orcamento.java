package io.github.jn.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 50)
    private BigDecimal valor;

    @Column(nullable = false, length = 8)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(nullable = true, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;
}
