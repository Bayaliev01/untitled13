package peaksoft.model.dao;

import peaksoft.model.Car;

import java.util.List;

public interface CarDao {

    void saveCar(Car car);

    Car getById(Long id);

    List<Car> getCarsByPersonId(Long id);

    List<Car> getCarsByPersonName(String name);

    List<Car> getAllCars();

    void deleteCarById(Long id);
}
