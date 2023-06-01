package br.com.iesp.barbearia.repository;

import Model.UrlPermissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserPermissaoRepository {
    @Repository
    public interface UrlPermissaoRepository extends JpaRepository<UrlPermissao, Long> {
    }
}
