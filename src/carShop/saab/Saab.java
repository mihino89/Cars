package carShop.saab;

import car.Car;

public class Saab extends Car {
    public Saab(String type, int doors, int price, boolean isManual) {
        super("Saab", type, 4, doors, price, isManual);
    }

    @Override
    public String created() {
        return "Car saab was created.";
    }
}
