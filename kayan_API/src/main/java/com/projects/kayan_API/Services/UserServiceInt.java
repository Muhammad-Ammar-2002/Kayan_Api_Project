package com.projects.kayan_API.Services;

import com.projects.kayan_API.Models.UserLoginDTO;
import com.projects.kayan_API.Models.UserDTO;

import java.util.List;

public interface UserServiceInt {

    UserDTO signUp(UserDTO newUser);
//    UserLoginDTO logIn(UserLoginDTO userLogin);
    List<UserDTO> gitAllUsers();

    String verify(UserLoginDTO user);
}
