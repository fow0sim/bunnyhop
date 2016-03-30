package eu.simmig.turtle;

public class Turtle {
    public static final int DIRECTION_N = 0;
    public static final int DIRECTION_E = 1;
    public static final int DIRECTION_S = 2;
    public static final int DIRECTION_W = 3;

    int direction;
    boolean isWriteMode;
    int x;
    int y;

    public Turtle() {
        init();
    }

    public void init() {
        setDirection(DIRECTION_N);
        setWriteMode(false);
        x = 0;
        y = 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isWriteMode() {
        return isWriteMode;
    }

    public void setWriteMode(boolean writeMode) {
        isWriteMode = writeMode;
    }

    public void turnLeft() {
        turn(-1);
    }

    public void turnRight() {
        turn(1);
    }

    public void turnAround() {
        turn(2);
    }

    public void turn(int angle) {
        int a = angle % 4;
        setDirection((getDirection() + 4 + (angle % 4)) % 4);
    }

    public void walk() {
        switch (getDirection()) {
            case DIRECTION_N:
                y -= 1;
                break;
            case DIRECTION_E:
                x += 1;
                break;
            case DIRECTION_S:
                y += 1;
                break;
            case DIRECTION_W:
                x -= 1;
                break;
        }
    }

    public void walk(int steps) {
        for (int i = 0; i < steps; i += 1) {
            walk();
        }
    }

}
