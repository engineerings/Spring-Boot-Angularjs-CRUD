package car.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car.shop.model.Car;

public class CarsStub {

    private static Map<Long, Car> cars = new HashMap<Long, Car>();
    private static Long idIndex = 3L;

    static {
        Car ferrari = new Car(1L, "Ferrari", "A very fast car", "320Km", 333.547, 2015);
        cars.put(1L, ferrari);
        Car honda = new Car(2L, "Honda", "Fabrication Japanese", "320Km", 333.547, 2015);
        cars.put(2L, honda);
        Car bmv = new Car(3L, "BMV", "A luxury car", "320Km", 333.547, 2015);
        cars.put(3L, bmv);
    }

    public static List<Car> list() {
        return new ArrayList<Car>(cars.values());
    }

    public static Car create(Car car) {
        idIndex += idIndex;
        car.setId(idIndex);
        cars.put(idIndex, car);
        return car;
    }

    public static Car get(Long id) {
        return cars.get(id);
    }

    public static Car update(Long id, Car car) {
        cars.put(id, car);
        return car;
    }

    public static Car delete(Long id) {
        return cars.remove(id);
    }

}
