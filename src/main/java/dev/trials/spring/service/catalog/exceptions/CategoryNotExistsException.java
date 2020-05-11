package dev.trials.spring.service.catalog.exceptions;

public class CategoryNotExistsException extends DomainException{

     /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CategoryNotExistsException(String message) {
        super(message);
    }

   

}