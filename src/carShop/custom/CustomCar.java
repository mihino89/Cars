package carShop.custom;

import personalCar.PersonalCar;

public class CustomCar extends PersonalCar {
    public CustomCar(String name, String type, int passedKm, int wheels, int doors, int price, boolean isManual, boolean forChildren) {
        super(name, type, passedKm, wheels, doors, price, isManual, forChildren);
    }

    @Override
    public String created() {
        return "Custom car " + getName() + " was created.";
    }
}
