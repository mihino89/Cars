package PersonalCar;

import Car.Car;
import Forms.BasicForm;

public class PersonalCar extends Car {
    private boolean forChildren;

    public PersonalCar(String name, String type, BasicForm basicForm, boolean forChildren) {
        super(name, type, basicForm);
        this.forChildren = forChildren;
    }

    public boolean isForChildren() {
        return forChildren;
    }
}
