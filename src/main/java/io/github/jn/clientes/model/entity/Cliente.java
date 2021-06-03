package io.github.jn.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@Table(uniqueConstraints= {@UniqueConstraint( columnNames = {"cnpj"} )} )
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    @NotEmpty(message = "{campo.nomeEmp.obrigatorio}")
    private String razaoSocial;

    @Column( name = "nome", nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 14)
    @NotBlank (message = "{campo.cnpj.obrigatorio}")
    @CNPJ(message = "{campo.cnpj.invalido}")
    private String cnpj;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "email", length = 45)
    @Email(message = "{campo.email.invalido}")
    private String email;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }
}
