package com.fullcycle.admin.catalogo.domain;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import java.util.Objects;

public abstract class Entity<ID extends Identifier>{

    protected final ID id;

    protected Entity (final ID id) {
        Objects.requireNonNull(id, "'id' should not be null");
        this.id = id;
    }
    public abstract void validate(ValidationHandler handler);

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals (final Object o ) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        com.fullcycle.admin.catalogo.domain.Entity<?> entity = (com.fullcycle.admin.catalogo.domain.Entity<?>) o;
        return java.util.Objects.equals ( getId ( ) , entity.getId ( ) );
    }

    @Override
    public
    int hashCode () {
        return java.util.Objects.hash ( getId ( ) );
    }
}
