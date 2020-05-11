package dev.trials.spring.service.catalog.exceptions;

public class ProductOutofStockToFulfilException extends DomainException{

    /**
    *
    */
   private static final long serialVersionUID = 1L;

   public ProductOutofStockToFulfilException(String message) {
       super(message);
   }

  

}