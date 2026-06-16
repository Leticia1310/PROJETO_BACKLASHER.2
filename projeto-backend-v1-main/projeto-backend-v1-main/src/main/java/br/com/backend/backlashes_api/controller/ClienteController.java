package br.com.backend.backlashes_api.controller;

import br.com.backend.backlashes_api.model.Cliente;
import br.com.backend.backlashes_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;

    @GetMapping //lista clientes (GET)
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping //cria clientes (POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("/{id}") //busca por id (GET)
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}") //atualiza cliente (PUT)
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return repository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                    return ResponseEntity.ok(repository.save(cliente));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}") //deleta cliente (DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
