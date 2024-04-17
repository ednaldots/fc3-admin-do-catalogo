package com.fullcycle.admin.catalogo.domain.category;
import com.fullcycle.admin.catalogo.domain.AggregateRoot;
import  com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import  com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.category.Category;

import java.time.Instant;

public abstract
class Category extends AggregateRoot <CategoryID>  {
    private final String name;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;
    private static Instant deletedAt;

    private Category(
            final CategoryID anId,
            final String aName,
            final String aDescription,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {

     super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdateDate;

}

    public static Category newCategory(final String aName, final String aDescription, final Boolean isActive ) {
       final var id = CategoryID.unique ();
       final var now = Instant.now ();
        return new Category ( id , aName , aDescription , isActive , now , now , deletedAt ) {
    @Override
    public void validate (final ValidationHandler throwsValidationHandler) {

            }
        };
    }

    @Override
    public void validate( final ValidationHandler handler ) {
        new CategoryValidator (this, handler).validate ();
    }
//    public String CategoryId getId() {
//        return id;
//    }

    public
    String getName () {
        return name;
    }

    public
    String getDescription () {
        return description;
    }

    public
    boolean isActive () {
        return active;
    }

    public
    java.time.Instant getCreatedAt () {
        return createdAt;
    }

    public
    java.time.Instant getUpdatedAt () {
        return updatedAt;
    }

    public static
    java.time.Instant getDeletedAt () {
        return deletedAt;
    }
}


