package br.com.backend.backlashes_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "disponibilidade")
@Data
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disponibilidade;

    @Column(nullable = false)
    private String diasemana;

    @Column(nullable = false)
    private LocalDateTime horainicio;

    @Column(nullable = false)
    private LocalDateTime horafim;

    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;
}

