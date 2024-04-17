package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.validation.Error;


import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.exception.DomainException;

import static com.fullcycle.admin.catalogo.domain.exception.DomainException.*;
import static java.util.List.*;

public abstract
class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append ( final Error anError ) {
        throw  with(java.util.List.of( ));
    }

    @Override
    public ValidationHandler append ( final ValidationHandler anHandler ) {
        throw with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate (final Validation aValidation )  {
       try{
           aValidation.validate();
       }catch (final Exception ex) {
           throw with( of(new java.lang.Error(ex.getMessage())));
       }
       return this;
    }

    @Override
    public
    java.util.List<java.lang.Error> getErrors () {
        return of();
    }
}
