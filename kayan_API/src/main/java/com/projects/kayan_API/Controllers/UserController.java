package com.projects.kayan_API.Controllers;

import com.projects.kayan_API.Exceptions.CustomeResponse;
import com.projects.kayan_API.Models.UserLoginDTO;
import com.projects.kayan_API.Models.UserDTO;
import com.projects.kayan_API.Services.UserServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class UserController {

    private final UserServiceInt userService;




    @PostMapping("/signup")
    private ResponseEntity<?> register(@RequestBody UserDTO user)
    {
        return new ResponseEntity<>(new CustomeResponse<>("01","success",Boolean.TRUE,userService.signUp(user)), HttpStatus.OK);
    }

    @GetMapping("/login")
    private ResponseEntity<?> login(@RequestBody UserLoginDTO user)
    {
        return new ResponseEntity<>(new CustomeResponse<>("01","success",Boolean.TRUE,userService.verify(user)), HttpStatus.OK);
    }


    @GetMapping("/allusers")
    private ResponseEntity<?> gettAllUsers()
    {
        return new ResponseEntity<>(
                new CustomeResponse<>(
                        "111","success",Boolean.TRUE,userService.gitAllUsers()
                ),HttpStatus.OK
        );
    }
}
