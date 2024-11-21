package com.projects.kayan_API.Exceptions;

import lombok.Setter;

@Setter
public class NotFoundException extends RuntimeException{


    public NotFoundException(String message)
    {
        super(message);
    }



}
