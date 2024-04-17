package com.fullcycle.admin.catalogo.domain;

public abstract
class AggregateRoot <ID extends Identifier> extends Entity<ID>{

    protected AggregateRoot (final ID id) {
        super (id);
    }

    public abstract
    void validate ( com.fullcycle.admin.catalogo.domain.validation.ValidationHandler handler );
}
