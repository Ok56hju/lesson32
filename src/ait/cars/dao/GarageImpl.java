package ait.cars.dao;

import ait.cars.model.Car;

import java.util.Arrays;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;
    public GarageImpl (int  capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || size == cars.length || findCarsByRegNumer(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumer) {
        Car res = findCarsByRegNumer(regNumer);
        if (res == null) return null;
        for (int i = 0; i < size; i++) {
            if (cars[i].equals(res)) {
                if (i == size - 1) {
                    res = cars[i];
                    cars[i] = null;
                    return res;
                }
                cars[i] = cars[--size];
                cars[size] = null;
                return res;
            }



        }
        return null;


    }

    @Override
    public Car findCarsByRegNumer(String regNumer) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber() == regNumer) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel() == model) {
                return new Car[]{cars[i]};
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getCompany() == company) {
                return new Car[]{cars[i]};
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getEngine() >= min && cars[i].getEngine() < max) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (cars[i].getEngine() >= min && cars[i].getEngine() < max) {
                res[j++] = cars[i];

            }
        }
        return res;
    }

    @Override
    public Car[] findCarsByColors(String color) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getColor() == color) {
                return new Car[]{cars[i]};
            }
        }
        return null;
    }
    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
//        int count = 0;
//        for (int i = 0; i < size; i++) {
//            if (predicate.test(cars[i])) {
//                count++;
//            }
//        }
        Car[] res = new Car[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                res[j++] = cars[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
