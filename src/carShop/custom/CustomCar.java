package carShop.custom;

import personalCar.PersonalCar;

public class CustomCar extends PersonalCar {
    private boolean created;
    public CustomCar(String name, String type, int passedKm, int wheels, int doors, int price, boolean isManual, boolean forChildren) {
        super(name, type, passedKm, wheels, doors, price, isManual, forChildren);
        this.created = false;
    }

    @Override
    public String created() {
        this.created = true;
        return "Custom car " + getName() + " was created.";
    }
}
