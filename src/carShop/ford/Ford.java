package carShop.ford;

import car.Car;

public class Ford extends Car {
    private boolean created;
    public Ford(String type, int doors, int price, boolean isManual) {
        super("Ford", type, 0, 4, doors, price, isManual);
        this.created = false;
    }

    @Override
    public String created() {
        this.created = true;
        return "Ford bol vytvoreny.";
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s autom Ford " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Aktualny stav tachometra: " + getPassedKm());
    }
}
