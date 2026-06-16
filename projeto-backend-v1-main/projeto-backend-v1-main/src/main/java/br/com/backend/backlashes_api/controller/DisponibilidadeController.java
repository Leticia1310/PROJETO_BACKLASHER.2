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
    @GetMapping("/{id}")
    public ResponseEntity<Disponibilidade> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(disponibilidade -> ResponseEntity.ok(disponibilidade))
                .orElse(ResponseEntity.notFound().build());
    }
    
     @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disponibilidade criar(@RequestBody Disponibilidade disponibilidade) {
        return repository.save(disponibilidade);
    }
    @PutMapping("/{id}")
public ResponseEntity<Disponibilidade> atualizar(@PathVariable Long id, @RequestBody Disponibilidade disponibilidadeAtualizada) {
    return repository.findById(id)
            .map(disponibilidade -> {
                disponibilidade.setDiasemana(disponibilidadeAtualizada.getDiasemana());
                disponibilidade.setHorainicio(disponibilidadeAtualizada.getHorainicio());
                disponibilidade.setHorafim(disponibilidadeAtualizada.getHorafim());
                
                disponibilidade.setProfissional(disponibilidadeAtualizada.getProfissional());
                return ResponseEntity.ok(repository.save(disponibilidade));
            })
            .orElse(ResponseEntity.notFound().build());
    
        }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
