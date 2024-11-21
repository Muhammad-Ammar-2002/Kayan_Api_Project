package com.projects.kayan_API.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomeResponse<T> {

    private String code;
    private String message;
    private Boolean success;
    private LocalDateTime dateTime;
    private T details=null;

    public CustomeResponse(String code, String message, Boolean success,T details) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.details=details;
        this.dateTime=LocalDateTime.now();
    }


}
