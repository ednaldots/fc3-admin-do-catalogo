package com.fullcycle.admin.catalogo.domain.validation;

public interface ValidationHandler {

    ValidationHandler append(Error anError);

    ValidationHandler append( java.lang.Error anHandler);

    com.fullcycle.admin.catalogo.domain.validation.ValidationHandler append ( com.fullcycle.admin.catalogo.domain.validation.ValidationHandler anHandler );

    ValidationHandler validate ( Validation aValidation );

    java.util.List<java.lang.Error> getErrors();
    default boolean hasError() {
        return getErrors() != null && !getErrors().isEmpty();
    }

    public interface Validation{
        void validate();
    }
}
