package carShop.jeep;

import car.Car;

public class Jeep extends Car {
    public Jeep(String type, int doors, int price, boolean isManual) {
        super("Jeep", type, 0, 4, doors, price, isManual);
    }

    @Override
    public String created() {
        return "Jeep was created.";
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s autom Jeep " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Actual car clock is: " + getPassedKm());
    }

    class Has4x4 {
        boolean has4x4;

        void checkHas4x4(){
            if(Jeep.super.getType().endsWith("4x4")){
                System.out.println("Type is: " + Jeep.super.getType());
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
