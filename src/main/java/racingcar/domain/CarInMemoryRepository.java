package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("위치를 비교하기 위한 자동차가 존재하지 않는다."));
    }

    @Override
    public List<Car> getCarsAt(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
