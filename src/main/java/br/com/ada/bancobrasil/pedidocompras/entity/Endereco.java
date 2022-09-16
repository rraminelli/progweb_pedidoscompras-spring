package br.com.ada.bancobrasil.pedidocompras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String logradouro;
    private String bairro;
    private String cidade;
    @Column(name = "uf", length = 2)
    private String uf;
    @Column(name = "cep", length = 9)
    private String cep;

    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Usuario usuario;

}
