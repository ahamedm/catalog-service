package dev.trials.spring.service.catalog.exceptions;

public class CategoryAlreadyExistsException extends DomainException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public CategoryAlreadyExistsException(String message) {
        super(message);
    }

    


}