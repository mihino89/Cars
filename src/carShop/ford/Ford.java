package carShop.ford;

import car.Car;

public class Ford extends Car {
    public Ford(String type, int doors, int price, boolean isManual) {
        super("Ford", type, 4, doors, price, isManual);
    }

    @Override
    public String created() {
        return "Ford was created.";
    }
}
