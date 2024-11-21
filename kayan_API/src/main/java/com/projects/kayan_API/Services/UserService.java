package com.projects.kayan_API.Services;

import com.projects.kayan_API.Entities.UserEntity;
import com.projects.kayan_API.Entities.UserPrincipals;
import com.projects.kayan_API.Exceptions.DuplicateRecordException;
import com.projects.kayan_API.Exceptions.NotFoundException;
import com.projects.kayan_API.Models.UserLoginDTO;
import com.projects.kayan_API.Models.UserDTO;
import com.projects.kayan_API.Repositories.UserRepoInt;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class UserService implements UserServiceInt {

    private final UserRepoInt userRepo;
    private final ModelMapper mapper=new ModelMapper();

    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    private final AuthenticationManager authManger;

    private final JWTService jwtService;


    @Override
    public UserDTO signUp(UserDTO newUser) {

         validateUserInput(newUser);

            UserEntity entity=userRepo.findByEmail(newUser.getEmail());
        if(userRepo.findByEmail(newUser.getEmail())!=null){

            throw new DuplicateRecordException("Email already exist");
        }
        if(userRepo.findByPhone(newUser.getPhone())!=null){

            throw new DuplicateRecordException("Phone already exist");
        }
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return mapper.map(userRepo.save(mapper.map(newUser, UserEntity.class)), UserDTO.class);

    }

    private void validateUserInput(UserDTO user)
    {
        if (user.getFName() == null || user.getJobTitle() == null || user.getLName() == null ||
                user.getEmail() == null || user.getPassword() == null || user.getPhone() == null ||
                user.getCity() == null || user.getCountry() == null || user.getAddress() == null)
        {
            throw new IllegalArgumentException("All user fields must be provided");
        }
        }

//    @Override
//    public UserLoginDTO logIn(UserLoginDTO userLogin) {
//
//
//          UserEntity userEntity=userRepo.findByEmail(userLogin.getEmail());
//          if(userEntity!=null)
//          {
//            return mapper.map(userEntity,UserLoginDTO.class);
//          }
//
//        return null;
//    }

    @Override
    public List<UserDTO> gitAllUsers() {
        return userRepo.findAll().stream().map(userEntity -> mapper.map(userEntity,UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String verify(UserLoginDTO user) {

        Authentication authentication=authManger.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

        if(!authentication.isAuthenticated())
        {

            throw new NotFoundException("Wrong Email or Password");
        }
        return jwtService.generateToken(user.getEmail());


    }


}
