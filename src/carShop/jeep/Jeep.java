package carShop.jeep;

import car.Car;

public class Jeep extends Car {
    private boolean created;
    public Jeep(String type, int doors, int price, boolean isManual) {
        super("Jeep", type, 0, 4, doors, price, isManual);
        this.created = false;
    }

    @Override
    public String created() {
        this.created = true;
        return "Jeep bol vytvoreny.";
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s autom Jeep " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Aktualny stav tachometra: " + getPassedKm());
    }

    class Has4x4 {
        boolean has4x4;

        void checkHas4x4(){
            if(Jeep.super.getType().endsWith("4x4")){
                this.has4x4 = true;
            } else {
                this.has4x4 = false;
            }
        }

        boolean getCheckOf4x4(){
            return this.has4x4;
        }
    }
}
