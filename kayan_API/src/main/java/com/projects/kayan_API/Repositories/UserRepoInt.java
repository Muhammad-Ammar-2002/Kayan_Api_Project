package com.projects.kayan_API.Repositories;

import com.projects.kayan_API.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoInt extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);

    UserEntity findByPhone(String phone);
}
