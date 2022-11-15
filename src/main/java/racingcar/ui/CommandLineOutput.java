package racingcar.ui;

import racingcar.utils.StringUtils;

import static racingcar.domain.CarValidator.MAX_CAR_NAME_LENGTH;

class CommandLineOutput {

    public static void askForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printCarNameTooLongError() {
        System.out.println("[ERROR] 경주할 자동차 이름의 길이는 " + MAX_CAR_NAME_LENGTH + " 이하여야 한다.");
    }

    public static void printCarNamePatternInvalidError() {
        System.out.println("[ERROR] 경주할 자동차 이름을 ,로 구분해서 입력해야 한다.");
    }

    public static void askForMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printMoveCountInvalidError() {
        System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    public static void printCarNameAndPosition(String carName, int position) {
        System.out.println(carName + " : " + StringUtils.repeat("-", position));
    }

    public static void printCarNames(String carNames) {
        System.out.println("최종 우승자 : " + carNames);
    }

    public static void nextLine() {
        System.out.println();
    }
}
