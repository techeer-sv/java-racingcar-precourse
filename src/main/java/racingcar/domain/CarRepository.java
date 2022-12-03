package racingcar.domain;

import java.util.List;

public interface CarRepository {

    void create(Car car);

    List<Car> findAll();

    int getMaxPosition();

    List<Car> getCarsAt(int position);
}
