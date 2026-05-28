package br.com.backend.backlashes_api.controller;

import br.com.backend.backlashes_api.model.Servico;
import br.com.backend.backlashes_api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public List<Servico> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico criar(@RequestBody Servico servico) {
        return repository.save(servico);
    }
}