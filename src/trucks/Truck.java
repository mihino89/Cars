package trucks;

import car.Car;

public class Truck extends Car {
    private int maxWeight;
    private boolean hasSemiTrailer;

    public Truck(String name, String type, int passedKm, int wheels, int doors, int price, boolean isManual, int maxWeight, boolean hasSemiTrailer) {
        super(name, type, passedKm, wheels, doors, price, isManual);
        this.maxWeight = maxWeight;
        this.hasSemiTrailer = hasSemiTrailer;
    }

    @Override
    public void move(int km) {
        System.out.println("Presli ste s " + getName() + " " + getType() + " " + km + " km.");
        setPassedKm(getPassedKm() + km);
        System.out.println("Actual car clock is: " + getPassedKm());
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public boolean isHasSemiTrailer() {
        return hasSemiTrailer;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
