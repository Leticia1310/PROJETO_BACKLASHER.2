package br.com.backend.backlashes_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profissional")
@Data
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profissional;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 100)
    private String especialidade;

    @Column(length = 15)
    private String telefone;
}