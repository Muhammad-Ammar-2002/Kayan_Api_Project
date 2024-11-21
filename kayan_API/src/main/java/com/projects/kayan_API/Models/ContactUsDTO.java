package com.projects.kayan_API.Models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactUsDTO {

    private String messageType;
    private String content;
    private Long userId;
}
