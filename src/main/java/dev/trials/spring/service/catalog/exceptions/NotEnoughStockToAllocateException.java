package dev.trials.spring.service.catalog.exceptions;

public class NotEnoughStockToAllocateException  extends DomainException{

    /**
    *
    */
   private static final long serialVersionUID = 1L;

   public NotEnoughStockToAllocateException(String message) {
       super(message);
   }

  

}