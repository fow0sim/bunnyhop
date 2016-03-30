package eu.simmig.turtle.test;

import eu.simmig.turtle.Turtle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurtleTest {

    @Test
    public void testDirection() {
        Turtle turtle = new Turtle();
        assertEquals(Turtle.DIRECTION_N, turtle.getDirection());
        turtle.setDirection(Turtle.DIRECTION_W);
        assertEquals(Turtle.DIRECTION_W, turtle.getDirection());
        turtle.turnRight();
        assertEquals(Turtle.DIRECTION_N, turtle.getDirection());
        turtle.turnAround();
        assertEquals(Turtle.DIRECTION_S, turtle.getDirection());
        turtle.turnLeft();
        assertEquals(Turtle.DIRECTION_E, turtle.getDirection());
        turtle.turn(-5);
        assertEquals(Turtle.DIRECTION_N, turtle.getDirection());
    }

}
