package com.projects.kayan_API.Repositories;

import com.projects.kayan_API.Entities.ContactUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepoInt extends JpaRepository<ContactUsEntity,Long> {
}
