package br.com.iesp.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UseRepository {
    @Repository
    public interface UserRepository<UserModel> extends JpaRepository<UserModel, Long> {

        Optional<UserModel> findByUserName(String userName);
    }

}
