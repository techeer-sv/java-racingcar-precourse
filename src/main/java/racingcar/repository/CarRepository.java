package racingcar.repository;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface CarRepository {

    void create(Car car);

    List<Car> findAll();

    int getMaxPosition();

    List<Car> getCarsAt(int position);
}
