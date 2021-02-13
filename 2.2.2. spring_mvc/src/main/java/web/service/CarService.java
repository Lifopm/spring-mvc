package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private int count;
    List<Car> cars =new ArrayList<>();

    public CarService(int count) {
        if(count > 5 || count < 1) {
            this.count = 5;
        } else {
            this.count = count;
        }
        cars.add(new Car("s1", 1, "red"));
        cars.add(new Car("s2", 2, "blue"));
        cars.add(new Car("s3", 3, "black"));
        cars.add(new Car("s4", 4, "white"));
        cars.add(new Car("s5", 5, "pink"));
    }

    public List<Car> getCars() {
        List<Car> carsForReturn = new ArrayList<>();

        for (int i = 0; i < count ; i++) {
            carsForReturn.add(cars.get(i));
        }

        return carsForReturn;
    }
}
