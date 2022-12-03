package racingcar.domain;

public class CarValidator {

    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("경주할 자동차 이름의 길이는 " + MAX_CAR_NAME_LENGTH + " 이하여야 한다.");
        }
    }
}
