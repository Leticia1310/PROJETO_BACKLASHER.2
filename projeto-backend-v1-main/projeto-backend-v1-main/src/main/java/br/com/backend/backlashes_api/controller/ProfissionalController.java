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
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(profissional -> ResponseEntity.ok(profissional))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional criar(@RequestBody Profissional profissional) {
        return repository.save(profissional);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id, @RequestBody Profissional profissionalAtualizado) {
        return repository.findById(id)
                .map(profissional -> {
                    profissional.setNome(profissionalAtualizado.getNome());
                    profissional.setEspecialidade(profissionalAtualizado.getEspecialidade());
                    profissional.setTelefone(profissionalAtualizado.getTelefone());
                    return ResponseEntity.ok(repository.save(profissional));
                })
                .orElse(ResponseEntity.notFound().build());
            } 

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
