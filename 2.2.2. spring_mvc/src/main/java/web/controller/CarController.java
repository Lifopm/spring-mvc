package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String PrintCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count, ModelMap model) {

        CarService carService = new CarService(count);
        List<Car> cars = carService.getCars();

        model.addAttribute("cars", cars);

        return "car";
    }

}