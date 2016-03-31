package eu.simmig.turtle;

import java.util.SortedSet;
import java.util.TreeSet;

public class Turtle {
    private static final int PRECISION = 8;

    private int direction;
    private Location location;
    private SortedSet<Location> points;

    public Turtle() {
        init();
    }

    public void init() {
        setDirection(Location.DIRECTION_N);
        location = new Location(0, 0);
        points = new TreeSet<Location>();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        turn(-(PRECISION / 4));
    }

    public void turnRight() {
        turn(PRECISION / 4);
    }

    public void turnAround() {
        turn(PRECISION / 2);
    }

    public void turn(int angle) {
        int a = angle % PRECISION;
        setDirection((getDirection() + PRECISION + (angle % PRECISION)) % PRECISION);
    }

    public void walk() {
        location = location.adjacentLocation(getDirection());
    }

    public void walk(int steps) {
        for (int i = 0; i < steps; i += 1) {
            walk();
        }
    }

    public void stepBack() {
        turnAround();
        walk();
        turnAround();
    }

    public void paint() {
        points.add(location);
    }

    public void draw(int steps) {
        for (int i = 0; i < steps; i += 1) {
            walk();
            paint();
        }
    }

    public Location relativeZero() {
        if (points.isEmpty()) {
            return new Location(0, 0);
        }
        int minX = 0;
        int minY = 0;
        for (Location point : points) {
            minX = Math.min(minX, point.getX());
            minY = Math.min(minY, point.getY());
        }
        return new Location(minX, minY);
    }

    public Location relativeMax() {
        if (points.isEmpty()) {
            return new Location(0, 0);
        }
        int maxX = 0;
        int maxY = 0;
        for (Location point : points) {
            maxX = Math.max(maxX, point.getX());
            maxY = Math.max(maxY, point.getY());
        }
        return new Location(maxX, maxY);
    }

    public Dimension getDimension() {
        if (points.isEmpty()) {
            return new Dimension(0, 0);
        }
        Location min = relativeZero();
        Location max = relativeMax();
        return new Dimension(max.getX() - min.getX() + 1, max.getY() - min.getY() + 1);
    }

    public int[][] toArray() {
        Location min = relativeZero();
        Location max = relativeMax();
        int width = max.getX() - min.getX() + 1;
        int height = max.getY() - min.getY() + 1;
        int[][] result = new int[height][width];
        for (Location point : points) {
            int x = point.getX() - min.getX();
            int y = point.getY() - min.getY();
            result[y][x] = 1;
        }
        return result;
    }

}
