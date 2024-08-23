package br.com.PontoBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


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
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    private String senha;
    @Column(unique = true, nullable = false)
    private String cpf;
    private Date dtCriacao;
    private Date dtAtualizacao;
    private boolean isAtivo;


    @ManyToOne()
    @JoinColumn(name = "departamento_id", referencedColumnName = "nome")
    private Departamento departamento;


    @OneToMany()
    @JoinColumn(name = "ponto_id", referencedColumnName = "id")
    private List<Ponto> pontos;

}