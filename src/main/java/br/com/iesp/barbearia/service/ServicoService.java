package br.com.iesp.barbearia.service;

import br.com.iesp.barbearia.entity.Servico;
import br.com.iesp.barbearia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico save(Servico venda){
        venda = repository.save(venda);
        return venda;
    }

    public Servico update(Servico venda){
        if(venda.getId() == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        venda = repository.save(venda);
        return venda;
    }

    public List<Servico> findAll(){
        return repository.findAll();
    }

    public Optional<Servico> findById(Long id){
        if(repository.findById(id).orElse(null) == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        return repository.findById(id);
    }

    public void delete(Servico venda){
        if(venda.getId() == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        repository.delete(venda);
    }
}
