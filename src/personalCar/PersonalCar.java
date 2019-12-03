package personalCar;

import car.Car;

public class PersonalCar extends Car {
    private boolean forChildren;

    public PersonalCar(String name, String type, int passedKm, int wheels, int doors, int price, boolean isManual, boolean forChildren) {
        super(name, type, passedKm, wheels, doors, price, isManual);
        this.forChildren = forChildren;
    }

    public boolean isForChildren() {
        return forChildren;
    }

    public String created(){
        return "Personal car was created.";
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s autom: " + getName() + " model: " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Aktualny tachometer auta: " + getPassedKm());
    }
}
