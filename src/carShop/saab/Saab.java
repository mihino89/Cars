package carShop.saab;

import car.Car;

public class Saab extends Car {
    public Saab(String type, int doors, int price, boolean isManual) {
        super("Saab", type,0,4, doors, price, isManual);
    }

    @Override
    public String created() {
        return "Car saab was created.";
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s autom Saab " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Actual car clock is: " + getPassedKm());
    }
}
