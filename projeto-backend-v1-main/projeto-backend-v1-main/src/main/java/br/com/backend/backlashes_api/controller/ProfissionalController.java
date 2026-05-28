package br.com.backend.backlashes_api.controller;

import br.com.backend.backlashes_api.model.Profissional;
import br.com.backend.backlashes_api.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @GetMapping
    public List<Profissional> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional criar(@RequestBody Profissional profissional) {
        return repository.save(profissional);
    }
}