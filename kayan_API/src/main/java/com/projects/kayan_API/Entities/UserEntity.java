package com.projects.kayan_API.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnError;
import lombok.*;
import org.intellij.lang.annotations.Pattern;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fname")
    private String fName;
    @Column(name = "lname")
    private String lName;
//    @Email
    private String email;
//    @NotBlank(message = "Password is required")
//    @Size(min=8 ,message = "Password must be at least 8 characters")
    private String password;
//    @Pattern(value = "^\\+?[0-9]{10,15}$")

    private String phone;
    private String country;
    private String city;
    @Column(name = "street")
    private String address;
    private String sid;
    @Column(name = "job_title")
    private String jobTitle;
    @ManyToMany
    @JoinTable(name = "askfor",
              joinColumns =@JoinColumn(name = "user_id") ,
               inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> product;


}
