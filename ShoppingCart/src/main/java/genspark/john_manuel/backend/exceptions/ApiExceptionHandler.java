package genspark.john_manuel.backend.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler{
    //entire class was written following this tutorial
    //https://www.baeldung.com/rest-with-spring-series
    
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e){
        ErrorResponse errors = new ErrorResponse();
        for(ConstraintViolation violation : e.getConstraintViolations()){
            ErrorItem errorItem = new ErrorItem();
            errorItem.setCode(violation.getMessageTemplate());
            errorItem.setMessage(violation.getMessage());
            errors.addError(errorItem);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e){
        ErrorItem errorItem = new ErrorItem();
        errorItem.setMessage(e.getMessage());
        
        return new ResponseEntity<>(errorItem, HttpStatus.NOT_FOUND);
    }
    
    public static class ErrorItem{
        
        @JsonInclude(JsonInclude.Include.NON_NULL) private String code;
        
        private String message;
    
        public String getCode(){return code;}
        public String getMessage(){return message;}
    
        public void setCode(String code){this.code = code;}
        public void setMessage(String message){this.message = message;}
    }
    
    public static class ErrorResponse{
        
        private List<ErrorItem> errors = new ArrayList<>();
        
        public List<ErrorItem> getErrors(){return errors;}
        
        public void setErrors(List<ErrorItem> errors){this.errors = errors;}
        
        public void addError(ErrorItem error){this.errors.add(error);}
    }
}
