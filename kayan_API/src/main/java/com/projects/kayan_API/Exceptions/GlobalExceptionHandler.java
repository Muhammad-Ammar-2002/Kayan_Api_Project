package com.projects.kayan_API.Exceptions;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException notFoundException)
    {
        return new ResponseEntity<>(
                   new CustomeResponse<>(
                        "02",
                        "fail",Boolean.FALSE,
                        notFoundException.getMessage()),
                   HttpStatus.NOT_FOUND

                );

    }


    @ExceptionHandler(value = DuplicateRecordException.class)
    public ResponseEntity<?> duplicateRecordException(DuplicateRecordException dx)
    {
        return new ResponseEntity<>(
                   new CustomeResponse<>(
                        "22",
                        "fail",Boolean.FALSE,
                        dx.getMessage()),
                   HttpStatus.CONFLICT

                );

    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
//    {
//        List<String> errors=new ArrayList<>();
//        for (FieldError error:ex.getBindingResult().getFieldErrors())
//        {
//            errors.add(error.getDefaultMessage());
//        }
//        for (ObjectError objectError: ex.getBindingResult().getFieldErrors())
//        {
//            errors.add(objectError.getDefaultMessage());
//        }
//
//        ErrorResponse errorResponse= new ErrorResponse() {
//            @Override
//            public HttpStatusCode getStatusCode() {
//                return HttpStatus.BAD_REQUEST;
//            }
//
//            @Override
//            public ProblemDetail getBody() {
//
//                ProblemDetail detail=ProblemDetail.forStatusAndDetail(getStatusCode(),"Validation Field");
//                detail.setTitle("Validation Error");
//                detail.setProperty("errors",errors);
//                return detail;
//            }
//        };
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errorResponse.getBody());
//    }

}
