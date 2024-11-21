package com.projects.kayan_API.Repositories;

import com.projects.kayan_API.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepoInt extends JpaRepository<ProductEntity,Long> {
}
