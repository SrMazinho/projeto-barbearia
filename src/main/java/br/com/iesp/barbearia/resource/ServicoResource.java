package br.com.iesp.barbearia.resource;

import br.com.iesp.barbearia.entity.Servico;
import br.com.iesp.barbearia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico s) {
        Servico servico = service.save(s);
        return ResponseEntity.status(201).body(servico);
    }

    @PutMapping
    public ResponseEntity<Servico> update(@RequestBody Servico s) {
        Servico servico = service.update(s);
        return ResponseEntity.status(201).body(servico);
    }

    @GetMapping
    public List<Servico> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Servico> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Servico s) {
        service.delete(s);
    }
}
