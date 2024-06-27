package br.com.PontoBack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private Date dtCriacao;
    private Date dtAtualizacao;
    private boolean isAtivo;

    @OneToMany()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Usuario> usuarios;
}
