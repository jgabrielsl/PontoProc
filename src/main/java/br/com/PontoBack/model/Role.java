package br.com.PontoBack.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private List<Usuario> usuarios;
}