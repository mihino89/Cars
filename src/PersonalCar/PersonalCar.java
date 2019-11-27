package PersonalCar;

import Car.Car;
import Forms.BasicForm;

public class PersonalCar extends Car {
    private boolean forChildren;

    public PersonalCar(String name, String type, int wheels, int doors, int price, boolean isManual, boolean forChildren) {
        super(name, type, wheels, doors, price, isManual);
        this.forChildren = forChildren;
    }

    public boolean isForChildren() {
        return forChildren;
    }
}
