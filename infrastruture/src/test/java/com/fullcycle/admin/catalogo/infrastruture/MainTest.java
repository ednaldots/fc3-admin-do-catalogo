package com.fullcycle.admin.catalogo.infrastruture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {

    @Test
    public void testMain() {
        Assertions.assertNotNull(new Main ());
        Main.main (new String[] {});
    }
}
