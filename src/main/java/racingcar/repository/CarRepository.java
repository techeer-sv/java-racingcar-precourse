package racingcar.repository;

import racingcar.Car;

import java.util.List;

public interface CarRepository {

    void create(Car car);

    List<Car> findAll();
}
