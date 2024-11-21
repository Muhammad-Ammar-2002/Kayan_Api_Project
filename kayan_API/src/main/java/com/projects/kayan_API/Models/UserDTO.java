package com.projects.kayan_API.Models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
public class UserDTO {


    private String fName;
    private String lName;
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min=8 ,message = "Password must be at least 8 characters")
    private String password;
    private String phone;
    private String country;
    private String city;
    private String address;
    private String sid;
    private String jobTitle;
}
