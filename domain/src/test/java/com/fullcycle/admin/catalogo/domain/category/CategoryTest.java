package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import com.fullcycle.admin.catalogo.domain.exception.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest  {

    @Test
    public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull( Category.getDeletedAt ());
    }

    @Test
    public void givenAAnInvalidNullName_whenCallNewCategoryAnValidate_thenShouldReceiveError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler(){
                    @Override
                    public ValidationHandler append ( Error anHandler ) {
                        return null;
                    }
                } ));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors ().size () );
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).getMessage());
    }


}
