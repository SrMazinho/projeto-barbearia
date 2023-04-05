package br.com.iesp.barbearia.service;

import br.com.iesp.barbearia.entity.Funcionario;
import br.com.iesp.barbearia.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario save(Funcionario funcionario){
        funcionario = repository.save(funcionario);
        return funcionario;
    }

    public Funcionario update(Funcionario funcionario){
        if(funcionario.getId() == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        funcionario = repository.save(funcionario);
        return funcionario;
    }

    public List<Funcionario> findAll(){
        return repository.findAll();
    }

    public Optional<Funcionario> findById(Long id){
        if(repository.findById(id).orElse(null) == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        return repository.findById(id);
    }

    public void delete(Funcionario funcionario){
        if(funcionario.getId() == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        repository.delete(funcionario);
    }
}
