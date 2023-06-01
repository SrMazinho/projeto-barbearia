package br.com.iesp.barbearia.resource;

import Model.RoleModel;
import br.com.iesp.barbearia.service.Servico;
import br.com.iesp.barbearia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
public class ServicoResource<Servico> {

    @Autowired
    private ServicoService service;

    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico s) {
        Servico servico = (Servico) ServicoResource''.save(s);
        return ResponseEntity.status(201).body(servico);
    }

    @PutMapping
    public ResponseEntity<Servico> update(@RequestBody Servico s) {
        Servico servico = (Servico) service.update((RoleModel) s);
        return ResponseEntity.status(201).body(servico);
    }

    @GetMapping
    public List<Servico> findAll() {
        return (List<Servico>) service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Servico> findById(@PathVariable Long id) {
        return (Optional<Servico>) service.findById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Servico s) {
        service.delete((br.com.iesp.barbearia.service.Servico) s);
    }
}
