package com.projects.kayan_API.Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {
    private String name;
    private String description;
    private Boolean isAvailable;

}
