package car.shop.controller;

import car.shop.model.Car;
import car.shop.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public List<Car> list () {
        return carRepository.findAll();
    }

    @RequestMapping(value = "cars", method = RequestMethod.POST)
    public Car create (@RequestBody Car car) {
        return carRepository.saveAndFlush(car);
    }

    @RequestMapping(value = "cars/{id}", method = RequestMethod.GET)
    public Car get (@PathVariable Long id) {
        return carRepository.findOne(id);
    }

    @RequestMapping(value = "cars/{id}", method = RequestMethod.PUT)
    public Car update (@PathVariable Long id, @RequestBody Car car) {
        Car oldCar = carRepository.findOne(id);
        BeanUtils.copyProperties(car, oldCar);
        return carRepository.saveAndFlush(oldCar);
    }

    @RequestMapping(value = "cars/{id}", method = RequestMethod.DELETE)
    public Car delete (@PathVariable Long id) {
        Car car = carRepository.findOne(id);
        carRepository.delete(car);
        return car;
    }
}
