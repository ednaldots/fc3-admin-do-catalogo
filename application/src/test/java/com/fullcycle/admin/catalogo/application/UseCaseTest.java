package com.fullcycle.admin.catalogo.application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class UseCaseTest {
    @Test
    public void testCreateUseCase(){
        Assertions.assertNotNull(new UseCase());
        Assertions.assertNotNull(new UseCase().execute());
    }
}
