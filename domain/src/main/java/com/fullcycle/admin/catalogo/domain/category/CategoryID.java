package com.fullcycle.admin.catalogo.domain.category;

import java.util.Objects;
import java.util.UUID;
public class CategoryID extends com.fullcycle.admin.catalogo.domain.Identifier {

    protected final String value;

    private CategoryID( String value ) {
       Objects.requireNonNull(value);
        this.value = value;
    }

    public static CategoryID unique() {
        return CategoryID.from(UUID.randomUUID());
    }

    public static CategoryID from(final String anId) {
        return new CategoryID (anId);
    }

    public static CategoryID from(final UUID anId) {
        return new CategoryID(anId.toString ().toLowerCase());
    }

    public String getValue () {
        return value;
    }

    @Override
    public
    boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        final com.fullcycle.admin.catalogo.domain.category.CategoryID that = (com.fullcycle.admin.catalogo.domain.category.CategoryID) o;
        return java.util.Objects.equals ( getValue ( ) , that.getValue ( ) );
    }

    @Override
    public
    int hashCode () {
        return java.util.Objects.hash ( getValue ( ) );
    }
}
