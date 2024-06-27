package br.com.PontoBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "ponto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date entrada;
    private Date saida;
    private Date dtCriacao;
    private Date dtAtualizacao;
    private boolean isAtivo;

    @ManyToOne()
    @JoinColumn(name = "ponto_id", referencedColumnName = "id")
    private Usuario usuario;

}