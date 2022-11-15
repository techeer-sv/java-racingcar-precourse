package racingcar;

public class CarValidator {

    public static boolean isValidCarName(String carName) {
        return carName.length() <= Car.MAX_CAR_NAME_LENGTH;
    }
}
