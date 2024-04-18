package com.fullcycle.admin.catalogo.domain.exception;

import java.util.List;
public class DomainException extends RuntimeException {

    private final List<Error> errors;

    private DomainException (final List<Error>anErrors) {
        super("");
        this.errors = anErrors;
    }

    public static DomainException with(final Error anErrors) {
        return new DomainException(List.of(anErrors));
    }

    public static DomainException with(final com.fullcycle.admin.catalogo.domain.validation.Error anErrors) {
        return new DomainException(anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
