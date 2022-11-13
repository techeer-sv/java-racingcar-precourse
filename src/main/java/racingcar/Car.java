package racingcar;

public class Car {

    private final String name;
    private int position = 0;
    private static final int VELOCITY = 1;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += VELOCITY;
    }

    public void stop() {
    }
}
