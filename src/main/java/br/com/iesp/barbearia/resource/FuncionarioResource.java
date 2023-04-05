package br.com.iesp.barbearia.resource;

import br.com.iesp.barbearia.entity.Funcionario;
import br.com.iesp.barbearia.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario f) {
        Funcionario funcionario = service.save(f);
        return ResponseEntity.status(201).body(funcionario);
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario f) {
        Funcionario funcionario = service.update(f);
        return ResponseEntity.status(201).body(funcionario);
    }

    @GetMapping
    public List<Funcionario> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Funcionario f) {
        service.delete(f);
    }
}
