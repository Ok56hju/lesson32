package ait.cars.dao;

import ait.cars.model.Car;

public interface Garage {
    boolean addCar(Car car);
//    int quantity();
    Car removeCar(String regNumer);
    Car findCarsByRegNumer(String regNumer);
    Car[] findCarsByModel(String model);
    Car[] findCarsByCompany(String company);
    Car[] findCarsByEngine( double min, double msx);
    Car[] findCarsByColors(String color);



}
