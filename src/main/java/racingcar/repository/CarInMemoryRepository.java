package racingcar.repository;

import racingcar.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarInMemoryRepository implements CarRepository {

    private final List<Car> cars = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void create(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    @Override
    public List<Car> getCarsAt(int position) {
        List<Car> targets = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                targets.add(car);
            }
        }
        return targets;
    }
}
