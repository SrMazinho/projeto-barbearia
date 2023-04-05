package br.com.iesp.barbearia.resource;

import br.com.iesp.barbearia.entity.Cliente;
import br.com.iesp.barbearia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente c) {
		Cliente cliente = service.save(c);
		return ResponseEntity.status(201).body(cliente);
	}

	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente c) {
		Cliente cliente = service.update(c);
		return ResponseEntity.status(201).body(cliente);
	}

	@GetMapping
	public List<Cliente> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping
	public void delete(@RequestBody Cliente c) {
		service.delete(c);
	}

}
