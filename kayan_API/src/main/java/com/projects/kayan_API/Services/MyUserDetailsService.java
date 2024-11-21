package com.projects.kayan_API.Services;

import com.projects.kayan_API.Entities.UserEntity;
import com.projects.kayan_API.Entities.UserPrincipals;
import com.projects.kayan_API.Exceptions.NotFoundException;
import com.projects.kayan_API.Repositories.UserRepoInt;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepoInt userRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user=userRepo.findByEmail(username);

        if (user==null)
        {
            throw new NotFoundException("Wrong Email or Password");
        }

        return new UserPrincipals(user);
    }
}
