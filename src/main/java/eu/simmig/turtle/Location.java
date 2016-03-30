package eu.simmig.turtle;

public final class Location {
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
    public int hashCode() {
        int hc = 17;
        int hashMultiplier = 59;
        hc = hc * hashMultiplier + x;
        hc = hc * hashMultiplier + y;
        return hc;
    }

    public boolean equals(Location other) {
        return (this.x == other.getX() && this.y == other.getY());
    }

}
