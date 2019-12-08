package carShop.saab;

import car.Car;

public class Saab extends Car {
    public Saab(String type, int doors, int price, boolean isManual) {
        super("Saab", type,0,4, doors, price, isManual);
    }

    @Override
    public String created() {
        return "Auto Saab bolo vytvorene.";
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s autom Saab " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Aktualny stav tachometra : " + getPassedKm());
    }
}
