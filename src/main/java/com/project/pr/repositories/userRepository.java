package com.project.pr.repositories;

import com.project.pr.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface userRepository extends JpaRepository<user, Integer> {
    Optional<user> findByEmailAndPassword(String email, String password);

    user findByEmail(String Email);


}