package br.com.iesp.barbearia.repository;

import Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleModelRepository {

    @Repository
    public interface roleModelRepository<RoleName> extends JpaRepository<RoleModel.rolemodel, Long> {

        public List<RoleModel> findByRoleNameIn(List<RoleName> roles);

    }


}
