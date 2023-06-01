package br.com.iesp.barbearia.repository;

import Model.RoleModel;
import br.com.iesp.barbearia.service.Servico;
import enuns.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<RoleModel, Long> {

    public List<RoleModel> findByRoleNameIn(List<RoleName> roles);

    void delete(Servico venda);
}