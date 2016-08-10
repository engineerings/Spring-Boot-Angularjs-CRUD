package car.shop.controller;

import car.shop.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CarController {

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public List<Car> list () {
        return CarsStub.list();
    }

    @RequestMapping(value = "cars/{id}", method = RequestMethod.GET)
    public Car get (@PathVariable Long id) {
        return CarsStub.get(id);
    }

    @RequestMapping(value = "cars", method = RequestMethod.POST)
    public Car create (@RequestBody Car car) {
        return CarsStub.create(car);
    }

    @RequestMapping(value = "cars/{id}", method = RequestMethod.PUT)
    public Car update (@PathVariable Long id, @RequestBody Car car) {
        return CarsStub.update(id, car);
    }

    @RequestMapping(value = "cars/{id}", method = RequestMethod.DELETE)
    public Car delete (@PathVariable Long id) {
        return CarsStub.delete(id);
    }
}
