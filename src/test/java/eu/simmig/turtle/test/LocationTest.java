package eu.simmig.turtle.test;

import eu.simmig.turtle.Location;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest {
    @Test
    public void testValueObject() {
        Location location1 = new Location(-1, 1);
        Location location2 = new Location(-1, 1);
        assertEquals(location1, location2);
    }

    @Test
    public void testSortOrder() {
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(-7,0));
        list.add(new Location(-7,1));
        list.add(new Location(1,1));
        list.add(new Location(8,2));
        list.add(new Location(8,3));
        SortedSet<Location> set = new TreeSet<Location>();
        set.add(list.get(2));
        set.add(list.get(2));
        set.add(list.get(0));
        set.add(list.get(0));
        set.add(list.get(4));
        set.add(list.get(3));
        set.add(list.get(1));
        assertEquals(5, set.size());
        assertArrayEquals(list.toArray(), set.toArray());
    }

    @Test
    public void testAdjacent() {
        Location location = new Location(0, 0);
        assertEquals(new Location(0, -1), location.adjacentLocation(Location.DIRECTION_N));
        assertEquals(new Location(1, 0), location.adjacentLocation(Location.DIRECTION_E));
        assertEquals(new Location(0, 1), location.adjacentLocation(Location.DIRECTION_S));
        assertEquals(new Location(-1, 0), location.adjacentLocation(Location.DIRECTION_W));
        assertEquals(new Location(1, -1), location.adjacentLocation(Location.DIRECTION_NE));
        assertEquals(new Location(-1, -1), location.adjacentLocation(Location.DIRECTION_NW));
        assertEquals(new Location(1, 1), location.adjacentLocation(Location.DIRECTION_SE));
        assertEquals(new Location(-1, 1), location.adjacentLocation(Location.DIRECTION_SW));
    }



}
