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
}
