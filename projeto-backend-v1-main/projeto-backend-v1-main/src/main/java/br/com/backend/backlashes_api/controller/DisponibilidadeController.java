package br.com.backend.backlashes_api.controller;

import br.com.backend.backlashes_api.model.Disponibilidade;
import br.com.backend.backlashes_api.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/v1/disponibilidades")
public class DisponibilidadeController {

    @Autowired
    private DisponibilidadeRepository repository;

    @GetMapping
    public List<Disponibilidade> listar() {
        return repository.findAll();
    }

     @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disponibilidade criar(@RequestBody Disponibilidade disponibilidade) {
        return repository.save(disponibilidade);
    }
}