package dev.trials.spring.service.catalog.exceptions;

public abstract class DomainException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    
    protected DomainException (String message) {
        super(message);
    }    
   
}