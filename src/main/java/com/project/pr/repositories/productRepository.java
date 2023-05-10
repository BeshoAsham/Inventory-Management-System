package com.project.pr.repositories;

import com.project.pr.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product, Integer> {

}
