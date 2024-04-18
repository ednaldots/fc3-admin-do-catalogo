package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.validation.Error;


import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.exception.DomainException;

import java.util.List;

import static java.util.List.*;

public abstract
class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append ( final Error anError ) {
        throw  DomainException.with( (java.lang.Error) of( ) );
    }

    @Override
    public ValidationHandler append ( final ValidationHandler anHandler ) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate (final Validation aValidation )  {
       try{
           aValidation.validate();
       }catch (final Exception ex) {
           throw DomainException.with( (java.lang.Error) of(new java.lang.Error(ex.getMessage())) );
       }
       return this;
    }

    @Override
    public
    com.fullcycle.admin.catalogo.domain.validation.Error getErrors () {
        return of();
    }
}
