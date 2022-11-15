package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.usecase.MoveOrStopCarUseCase;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ui.CommandLineInput.inputCarNames;
import static racingcar.ui.CommandLineInput.inputMoveCount;
import static racingcar.ui.CommandLineOutput.askForCarNames;
import static racingcar.ui.CommandLineOutput.askForMoveCount;
import static racingcar.ui.CommandLineOutput.nextLine;
import static racingcar.ui.CommandLineOutput.printCarNameAndPosition;
import static racingcar.ui.CommandLineOutput.printCarNames;
import static racingcar.utils.RandomNumberGenerator.generateRandomNumber;

public class CommandLineUserInterface implements UserInterface {

    private final CarRepository carRepository;
    private final MoveOrStopCarUseCase moveOrStopUseCase;

    public CommandLineUserInterface(CarRepository carRepository, MoveOrStopCarUseCase moveOrStopUseCase) {
        this.carRepository = carRepository;
        this.moveOrStopUseCase = moveOrStopUseCase;
    }

    @Override
    public void deployCars() {
        String[] carNames = promptCarNames();
        createCars(carNames);
    }

    @Override
    public void moveCars() {
        int moveCount = promptMoveCount();
        for (int i = 0; i < moveCount; i++) {
            carRepository.findAll().forEach((car) -> {
                moveOrStopUseCase.moveOrStop(car, generateRandomNumber());
                printCarNameAndPosition(car.getName(), car.getPosition());
            });
            nextLine();
        }
    }

    @Override
    public void getWinners() {
        int maxPosition = carRepository.getMaxPosition();
        String winnerNames = String.join(", ", getCarNamesAt(maxPosition));
        printCarNames(winnerNames);
    }

    private String[] promptCarNames() {
        askForCarNames();
        return inputCarNames();
    }

    private int promptMoveCount() {
        askForMoveCount();
        return inputMoveCount();
    }

    private void createCars(String[] carNames) {
        for (String carName : carNames) {
            carRepository.create(new Car(carName));
        }
    }

    private List<String> getCarNamesAt(int position) {
        return carRepository.getCarsAt(position).stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
