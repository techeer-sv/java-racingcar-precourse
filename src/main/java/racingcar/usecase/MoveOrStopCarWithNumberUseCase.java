package racingcar.usecase;

import racingcar.domain.Car;

public class MoveOrStopCarWithNumberUseCase implements MoveOrStopCarUseCase {

    private final int carMoveLowerBoundInclusive;

    public MoveOrStopCarWithNumberUseCase(int carMoveLowerBoundInclusive) {
        this.carMoveLowerBoundInclusive = carMoveLowerBoundInclusive;
    }

    @Override
    public void moveOrStop(Car car, int moveNumber) {
        if (moveNumber >= carMoveLowerBoundInclusive) {
            move(car);
            return;
        }

        stop(car);
    }

    @Override
    public void move(Car car) {
        car.moveForward();
    }

    @Override
    public void stop(Car car) {
        car.stop();
    }
}
