package racingcar.domain;

public class Car {

    private final String name;
    private final int velocity;
    private int position = 0;

    public Car(String name, int velocity) {

        this.name = name;
        this.velocity = velocity;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += velocity;
    }

    public void stop() {
    }
}
