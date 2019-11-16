package Trucks;

import java.util.ArrayList;

public class TruckList {
    private ArrayList<Truck> truckArrayList = new ArrayList<Truck>();

    public void addTruck(Truck truck){
        truckArrayList.add(truck);
    }

    public void printTruckList(){
        System.out.println("Pocet nakladnych vozidiel v databaze: " + truckArrayList.size());

        for(int i = 0; i < truckArrayList.size(); i++){
            System.out.println((i + 1) + ". Name " + truckArrayList.get(i).getName() +
            " Type: " + truckArrayList.get(i).getType() + " and max weight is : " +
            truckArrayList.get(i).getMaxWeight());
        }
    }
}
