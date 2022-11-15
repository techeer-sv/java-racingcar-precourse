package racingcar.usecase;

import racingcar.domain.Car;

public class MoveOrStopCarWithNumberUseCase implements MoveOrStopCarUseCase {

    private static final int CAR_MOVE_LOWER_BOUND_INCLUSIVE = 4;

    @Override
    public void moveOrStop(Car car, int moveNumber) {
        if (moveNumber >= CAR_MOVE_LOWER_BOUND_INCLUSIVE) {
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
