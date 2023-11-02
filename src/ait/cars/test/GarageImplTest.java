package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    Garage garage;
    Car[] avto;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        avto = new Car[3];
        avto[0] = new Car("ZN6798", "X5", "BMW", 2890, "Red");
        avto[1] = new Car("VF6785", "A8", "Audi", 3000, "blau");
        avto[2] = new Car("WN8765", "civic", "Honda", 1978, "Red");
        for (int i = 0; i < avto.length; i++) {
            garage.addCar(avto[i]);
        }
    }

    @org.junit.jupiter.api.Test
    void addCar() {
        assertFalse(garage.addCar(null));
        Car car = new Car("VF6788", "X5", "BMW", 2890, "RED");
        assertTrue(garage.addCar(car));
        car = new Car ("VF6787", "X5", "BMW", 2890, "RED");
        assertFalse(garage.addCar(car));
    }

    @org.junit.jupiter.api.Test
    void removeCar() {
        Car car = garage.removeCar("WN8765");
        assertEquals(avto[2],car);
//        assertEquals();
        assertNull(garage.removeCar("WN8765"));
    }

    @org.junit.jupiter.api.Test
    void findCarsByRegNumer() {
    }

    @org.junit.jupiter.api.Test
    void findCarsByModel() {
    }

    @org.junit.jupiter.api.Test
    void findCarsByCompany() {
    }

    @org.junit.jupiter.api.Test
    void findCarsByEngine() {
    }

    @Test
    void findCarsByColor() {
        Car[] expecteds = { avto[0], avto[2] };
        Car[] actuals = garage.findCarsByColors(new String("Red"));
        assertArrayEquals(expecteds, actuals);
//        assertArrayEquals(new Car[0], garage.findCarsByColors("Black"));
    }
}