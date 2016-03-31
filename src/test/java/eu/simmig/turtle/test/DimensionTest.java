package eu.simmig.turtle.test;

import eu.simmig.turtle.Dimension;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DimensionTest {
    @Test
    public void testValueObject() {
        Dimension dim1 = new Dimension(1, 1);
        Dimension dim2 = new Dimension(1, 1);
        assertEquals(dim1, dim2);
    }
}
