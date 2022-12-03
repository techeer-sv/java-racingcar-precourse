package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.PatternSyntaxException;

import static racingcar.domain.CarValidator.validateCarName;

class CommandLineInput {

    public static String[] inputCarNames() {
        try {
            String[] carNames = Console.readLine().split(",");
            for (String carName : carNames) {
                validateCarName(carName);
            }
            return carNames;
        } catch (PatternSyntaxException patternException) {
            throw new IllegalArgumentException("경주할 자동차 이름을 ,로 구분해서 입력해야 한다.");
        }
    }

    public static int inputMoveCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }
}
