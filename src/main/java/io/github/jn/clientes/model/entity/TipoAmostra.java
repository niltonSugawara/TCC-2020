package io.github.jn.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TipoAmostra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String volume;

    @Column(nullable = false, length = 250)
    private String categoria;

    /*
    *
SELECT a.nome, b.nome
FROM cliente as A
INNER JOIN amostra as B
on a.nome = b.nome

SELECT * FROM AMOSTRA

INSERT INTO amostra (descricao, nome, id_cliente, id_tipo_amostra) VALUES ('Teste Amostra UM', 'Nome Amostra UM',1,2);
INSERT INTO amostra (descricao, nome, id_cliente, id_tipo_amostra) VALUES ('Teste Amostra DOIS ', 'Nome Amostra DOIS',3,2);
INSERT INTO amostra (descricao, nome, id_cliente, id_tipo_amostra) VALUES ('Teste Amostra TRES', 'Nome Amostra TRES',4,4);
INSERT INTO amostra (descricao, nome, id_cliente, id_tipo_amostra) VALUES ('Teste Amostra QUATRO', 'Nome Amostra QUATRO',2,1);

INSERT INTO tipo_amostra (categoria, nome, volume) VALUES ('Teste Amostra UM', 'Nome Amostra UM' ,'liquid ');
INSERT INTO tipo_amostra (categoria, nome, volume) VALUES ('Teste Amostra UM', 'Nome Amostra UM' ,'liquid ');
INSERT INTO tipo_amostra (categoria, nome, volume) VALUES ('Teste Amostra UM', 'Nome Amostra UM' ,'liquid ');
INSERT INTO tipo_amostra (categoria, nome, volume) VALUES ('Teste Amostra UM', 'Nome Amostra UM' ,'liquid ');

*/

}
