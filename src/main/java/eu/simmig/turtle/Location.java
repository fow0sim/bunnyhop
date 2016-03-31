package eu.simmig.turtle;

public final class Location implements Comparable<Location> {
    public static final int DIRECTION_N = 0;
    public static final int DIRECTION_NE = 1;
    public static final int DIRECTION_E = 2;
    public static final int DIRECTION_SE = 3;
    public static final int DIRECTION_S = 4;
    public static final int DIRECTION_SW = 5;
    public static final int DIRECTION_W = 6;
    public static final int DIRECTION_NW = 7;

    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Location adjacentLocation(int direction) {
        switch (direction) {
            case DIRECTION_N:
                return new Location(x, y - 1);
            case DIRECTION_NE:
                return new Location(x + 1, y - 1);
            case DIRECTION_E:
                return new Location(x + 1, y);
            case DIRECTION_SE:
                return new Location(x + 1, y + 1);
            case DIRECTION_S:
                return new Location(x, y + 1);
            case DIRECTION_SW:
                return new Location(x - 1, y + 1);
            case DIRECTION_W:
                return new Location(x - 1, y);
            case DIRECTION_NW:
                return new Location(x - 1, y - 1);
        }
        throw new IllegalArgumentException("Invalid direction " + direction );
    }

    @Override
    public int hashCode() {
        int hc = 17;
        int hashMultiplier = 59;
        hc = hc * hashMultiplier + x;
        hc = hc * hashMultiplier + y;
        return hc;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        return (this.x == other.getX() && this.y == other.getY());
    }

    @Override
    public int compareTo(Location other) {
        if (this.x == other.getX()) {
            return Integer.compare(this.y, other.getY());
        }
        return Integer.compare(this.x, other.getX());
    }
}
