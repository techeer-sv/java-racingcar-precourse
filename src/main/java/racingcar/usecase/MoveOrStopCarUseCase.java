package racingcar.usecase;

import racingcar.Car;

public interface MoveOrStopCarUseCase extends MoveUseCase, StopUseCase {

    void moveOrStop(Car car, int moveNumber);
}

interface MoveUseCase {

    void move(Car car);
}


interface StopUseCase {

    void stop(Car car);
}
