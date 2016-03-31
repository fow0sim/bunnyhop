package eu.simmig.turtle;

public final class Dimension implements Comparable<Dimension> {

    private final int width;
    private final int height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int hashCode() {
        int hc = 17;
        int hashMultiplier = 59;
        hc = hc * hashMultiplier + width;
        hc = hc * hashMultiplier + height;
        return hc;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dimension)) {
            return false;
        }
        Dimension other = (Dimension) object;
        return (width == other.getWidth() && height == other.getHeight());
    }

    @Override
    public int compareTo(Dimension other) {
        return Integer.compare(width * height, other.getWidth() * other.getHeight());
    }
}
