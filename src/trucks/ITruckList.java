package trucks;

import trucks.Truck;

public interface ITruckList {
    public void addTruck(Truck truck);
    public void printTruckList();
    public void removeTruck(String truckName, String errorMessage);
    public int buyTruck(String truckName, String errorMessage);
    public void modifyTruck(String truckName);
}
