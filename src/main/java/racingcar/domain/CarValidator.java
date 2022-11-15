package racingcar.domain;

public class CarValidator {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static boolean isValidCarName(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }
}
