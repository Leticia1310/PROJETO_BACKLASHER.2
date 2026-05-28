package br.com.backend.backlashes_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agendamento;

    @Column(nullable = false)
    private LocalDateTime data_hora;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico servico;

    @Column(length = 50)
    private String status = "Pendente";
}