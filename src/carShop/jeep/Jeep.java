package carShop.jeep;

import car.Car;

public class Jeep extends Car {
    public Jeep(String type, int doors, int price, boolean isManual) {
        super("Saab", type, 4, doors, price, isManual);
    }

    @Override
    public String created() {
        return "Jeep was created.";
    }
}
