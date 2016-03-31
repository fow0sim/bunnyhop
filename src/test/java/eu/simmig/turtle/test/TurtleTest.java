package eu.simmig.turtle.test;

import eu.simmig.turtle.Dimension;
import eu.simmig.turtle.Location;
import eu.simmig.turtle.Turtle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurtleTest {

    @Test
    public void testDirection() {
        Turtle turtle = new Turtle();
        assertEquals(Location.DIRECTION_N, turtle.getDirection());
        turtle.setDirection(Location.DIRECTION_W);
        assertEquals(Location.DIRECTION_W, turtle.getDirection());
        turtle.turnRight();
        assertEquals(Location.DIRECTION_N, turtle.getDirection());
        turtle.turnAround();
        assertEquals(Location.DIRECTION_S, turtle.getDirection());
        turtle.turnLeft();
        assertEquals(Location.DIRECTION_E, turtle.getDirection());
        turtle.turn(-10);
        assertEquals(Location.DIRECTION_N, turtle.getDirection());
    }

    @Test
    public void testDimensionAndArray() {
        Turtle turtle = new Turtle();
        assertEquals(new Dimension(0, 0), turtle.getDimension());
        int[][] emptyArray = turtle.toArray();
        turtle.paint();
        turtle.draw(10);
        assertEquals(new Dimension(1, 11), turtle.getDimension());
        turtle.turnRight();
        turtle.draw(7);
        assertEquals(new Dimension(8, 11), turtle.getDimension());
        turtle.turnRight();
        turtle.draw(7);
        assertEquals(new Dimension(8, 11), turtle.getDimension());
        int[][] array = turtle.toArray();
        assertEquals(11, array.length);
        assertEquals(8, array[0].length);
        String str;
        for (int i = 0; i < 11; i += 1) {
            str = "";
            for (int j = 0; j < 8; j += 1) {
                str += array[i][j];
            }
            System.out.println(str);
        }
    }

}
