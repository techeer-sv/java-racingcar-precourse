package racingcar;

import racingcar.repository.CarInMemoryRepository;
import racingcar.ui.CommandLineUserInterface;
import racingcar.ui.UserInterface;
import racingcar.usecase.MoveOrStopCarWithNumberUseCase;

public class Application {

    public static void main(String[] args) {
        UserInterface ui = new CommandLineUserInterface(new CarInMemoryRepository(), new MoveOrStopCarWithNumberUseCase());
        boolean inputValid = false;

        while (!inputValid) {
            try {
                ui.deployCars();
                ui.moveCars();
                inputValid = true;
            } catch (IllegalArgumentException ignored) {
            }
        }
        ui.getWinners();
    }
}
