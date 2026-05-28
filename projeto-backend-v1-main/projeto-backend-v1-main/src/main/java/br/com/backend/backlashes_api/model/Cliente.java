package br.com.backend.backlashes_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cliente")
@Data

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 15)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(unique = true, length = 11)
    private String cpf;
}