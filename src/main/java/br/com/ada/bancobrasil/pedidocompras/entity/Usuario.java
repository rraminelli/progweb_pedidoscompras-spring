package br.com.ada.bancobrasil.pedidocompras.entity;

import br.com.ada.bancobrasil.pedidocompras.entity.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome deve ser preenchido")
    @Column(name = "nome", length = 80)
    private String nome;

    @NotNull(message = "CPF deve ser preenchido")
    @Column(name = "cpf", length = 14)
    private String cpf;

    @NotNull
    @Column(name = "email", length = 50)
    @Pattern(message = "Formato invalido", regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
    private String email;

    @NotNull(message = "Senha deve ser preenchido")
    @Length(min = 8, message = "Minimo de 8 caracteres")
    private String senha;

    @NotNull(message = "Endereço deve ser preenchido")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

}
