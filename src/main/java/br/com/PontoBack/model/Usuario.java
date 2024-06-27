package br.com.PontoBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Date dtCriacao;
    private Date dtAtualizacao;
    private boolean isAtivo;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Departamento departamento;

    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToMany()
    @JoinColumn(name = "ponto_id", referencedColumnName = "id")
    private List<Ponto> pontos;

}