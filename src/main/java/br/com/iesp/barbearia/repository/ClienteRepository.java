package br.com.iesp.barbearia.repository;

import br.com.iesp.barbearia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM barbearia.cliente c where c.nome like '% :nome1'", nativeQuery = true)
   public List <Cliente> buscarCliente(@Param("nome1") String nome1);

}
