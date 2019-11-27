package Trucks;

import Car.Car;
import Forms.BasicForm;

import java.util.Base64;

public class Truck extends Car {
    private int maxWeight;
    private boolean hasSemiTrailer;

    public Truck(String name, String type, int wheels, int doors, int price, boolean isManual, int maxWeight, boolean hasSemiTrailer) {
        super(name, type, wheels, doors, price, isManual);
        this.maxWeight = maxWeight;
        this.hasSemiTrailer = hasSemiTrailer;
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
