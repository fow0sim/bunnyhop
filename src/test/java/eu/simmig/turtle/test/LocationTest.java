package eu.simmig.turtle.test;

import eu.simmig.turtle.Location;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest {
    @Test
    public void testValueObject() {
        Location location1 = new Location(-1, 1);
        Location location2 = new Location(-1, 1);
        assertTrue(location1.equals(location2));
    }
}
