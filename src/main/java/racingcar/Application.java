package racingcar;

import racingcar.domain.CarInMemoryRepository;
import racingcar.ui.CommandLineUserInterface;
import racingcar.ui.UserInterface;
import racingcar.usecase.MoveOrStopCarWithNumberUseCase;

public class Application {

    private static final int CAR_VELOCITY = 1;

    public static void main(String[] args) {
        UserInterface ui = new CommandLineUserInterface(
                new CarInMemoryRepository(),
                new MoveOrStopCarWithNumberUseCase(4),
                CAR_VELOCITY
        );
        boolean inputValid = false;

        while (!inputValid) {
            try {
                ui.deployCars();
                ui.moveCars();
                inputValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        ui.getWinners();
    }
}
