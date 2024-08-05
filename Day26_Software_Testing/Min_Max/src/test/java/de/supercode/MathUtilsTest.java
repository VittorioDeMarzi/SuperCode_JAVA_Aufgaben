package de.supercode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    @Test
    public void canDefineMaxValue(){
        MathUtils mu = new MathUtils();
        int max = mu.max(-10, 20);
        assertEquals(20, max);
    }

    @Test
    public void canDefineMinValue() {
        MathUtils mu = new MathUtils();
        int min = mu.min(-10, 20);
        assertEquals(-10, min);
    }
}
