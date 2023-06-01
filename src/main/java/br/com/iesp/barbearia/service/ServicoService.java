package br.com.iesp.barbearia.service;

import Model.RoleModel;
import br.com.iesp.barbearia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public RoleModel save(RoleModel role){
        role = repository.save(role);
        return role;
    }

    public RoleModel update(RoleModel role){
        if(role.getId() == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        role = repository.save(role);
        return role;
    }

    public List<RoleModel> findAll(){
        return repository.findAll();
    }

    public Optional<RoleModel> findById(Long id){
        if(repository.findById(id).orElse(null) == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        return repository.findById(id);
    }

    public void delete(Servico role){
        if(role.getId() == null){
            throw new RuntimeException("Objeto inexistente.");
        }
        repository.delete(role);
    }
}