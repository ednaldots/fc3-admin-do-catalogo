package com.fullcycle.admin.catalogo.domain.category;

import java.time.Instant;
import java.time.Instant;
import java.util.UUID;

public class Category {
    public String id;
    private final String name;
    private final String description;
    private final boolean active;
    private final Instant createdAt;
    private final Instant updatedAt;
    private static Instant deletedAt;

    public
    Category ( final String id , final String name , final String description , final boolean active , final Instant createdAt , final Instant updatedAt

    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    public static Category newCategory(final String aName, final String aDescription, final Boolean isActive ) {
       final var id = UUID.randomUUID().toString();
       final var now = Instant.now ();
        return new Category(id, aName, aDescription, isActive, now, now);
    }

    public
    String getId () {
        return id;
    }

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


