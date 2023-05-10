package com.project.pr.repositories;

import com.project.pr.models.product;
import com.project.pr.models.stockRequest;
import com.project.pr.models.user;
import com.project.pr.models.warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface stockRequestRepository extends JpaRepository<stockRequest, Integer> {
    boolean existsByWarehouseAndProductAndUser(warehouse warehouse, product product, user user);

}
