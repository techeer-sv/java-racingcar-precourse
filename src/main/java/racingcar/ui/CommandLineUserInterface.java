package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car;
import racingcar.repository.CarRepository;
import racingcar.usecase.MoveOrStopCarUseCase;
import racingcar.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class CommandLineUserInterface implements UserInterface {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final CarRepository carRepository;
    private final MoveOrStopCarUseCase moveOrStopUseCase;

    public CommandLineUserInterface(CarRepository carRepository, MoveOrStopCarUseCase moveOrStopUseCase) {
        this.carRepository = carRepository;
        this.moveOrStopUseCase = moveOrStopUseCase;
    }

    @Override
    public void deployCars() {
        askForCarNames();
        String[] carNames = inputCarNames();
        createCars(carNames);
    }

    private void askForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String[] inputCarNames() {
        try {
            String[] carNames = Console.readLine().split(",");
            for (String carName : carNames) {
                if (carName.length() > MAX_CAR_NAME_LENGTH) {
                    printCarNameTooLongError();
                    throw new IllegalArgumentException();
                }
            }
            return carNames;
        } catch (PatternSyntaxException patternException) {
            printCarNamePatternInvalidError();
            throw new IllegalArgumentException();
        }
    }

    private void printCarNameTooLongError() {
        System.out.println("[ERROR] 경주할 자동차 이름의 길이는 5 이하여야 한다.");
    }

    private void printCarNamePatternInvalidError() {
        System.out.println("[ERROR] 경주할 자동차 이름을 ,로 구분해서 입력해야 한다.");
    }

    @Override
    public void moveCars() {
        askForMoveCount();
        int moveCount = inputMoveCount();
        for (int i = 0; i < moveCount; i++) {
            for (Car car : carRepository.findAll()) {
                moveOrStopUseCase.moveOrStop(car, Randoms.pickNumberInRange(0, 9));
                System.out.println(car.getName() + " : " + StringUtils.repeat("-", car.getPosition()));
            }
            System.out.println();
        }
    }

    private void askForMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private int inputMoveCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            printMoveCountInvalidError();
            throw new IllegalArgumentException();
        }
    }

    private void printMoveCountInvalidError() {
        System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    @Override
    public void getWinners() {
        int maxPosition = getMaxPosition();

        String winnerNames = String.join(", ", getCarNamesAt(maxPosition));
        printCarNames(winnerNames);
    }

    private void printCarNames(String carNames) {
        System.out.println("최종 우승자 : " + carNames);
    }

    public void createCars(String[] carNames) {
        for (String carName : carNames) {
            carRepository.create(new Car(carName));
        }
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : carRepository.findAll()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getCarNamesAt(int position) {
        return getCarsAt(position).stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getCarsAt(int position) {
        List<Car> winners = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            if (car.getPosition() == position) {
                winners.add(car);
            }
        }
        return winners;
    }
}
