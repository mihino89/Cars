package Trucks;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckList {
    private ArrayList<Truck> truckArrayList = new ArrayList<Truck>();
    private static Scanner scanner = new Scanner(System.in);

    public void addTruck(Truck truck){
        truckArrayList.add(truck);
    }

    public void printTruckList(){
        System.out.println("Pocet nakladnych vozidiel v databaze: " + truckArrayList.size());

        for(int i = 0; i < truckArrayList.size(); i++){
            System.out.println((i + 1) + ". Name " + truckArrayList.get(i).getBasicForm().getName() +
            " Type: " + truckArrayList.get(i).getBasicForm().getType() + " and max weight is : " +
            truckArrayList.get(i).getMaxWeight());
        }
    }

    private int findTruckByName(String searchedCar){
        for(int i = 0; i < truckArrayList.size(); i++){
            if(searchedCar.equals(truckArrayList.get(i).getBasicForm().getName())){
                return i;
            }
        }
        return -1;
    }

    private void removeTruck(int position){
        truckArrayList.remove(position);
    }

    public void removeTruck(String truckName, String errorMessage){
        int position = findTruckByName(truckName);

        if(position >= 0){
            removeTruck(position);
            System.out.println("Nakladne auto " + truckName + " bolo uspesne vymazane");
        } else {
            System.out.println(errorMessage);
        }
    }

    public int buyTruck(String truckName, String errorMessage){
        int position = findTruckByName(truckName);
        int price = -1;

        if(position >= 0){
            price = truckArrayList.get(position).getBasicForm().getPrice();
            removeTruck(position);
            return price;
        }

        System.out.println(errorMessage);
        return price;
    }

    private void printModifyInstructions(){
        System.out.println("\t 0 - Vypisat menu pre modifikovanie nakladneho auta");
        System.out.println("\t 1 - Modifikovat nazov nakladneho auta");
        System.out.println("\t 2 - Modifikovat cenu nakladneho auta");
        System.out.println("\t 3 - Modifikovat typ nakladneho auta");
        System.out.println("\t 4 - Ukoncit modifikaciu nakladneho auta");
    }

    private void modifyTryckName(int position, String truckName){
        String newTruckName;

        System.out.println("Zadajte novy nazov auta: " + truckName);
        newTruckName = scanner.nextLine();
        truckArrayList.get(position).getBasicForm().setName(newTruckName);
        System.out.println("Novy nazov auta je: " + truckArrayList.get(position).getBasicForm().getName());
    }

    private void modifyTruckPrice(int position, String truckName){
        int newPrice;

        System.out.println("Zadajte novu cenu auta: " + truckName);
        newPrice = scanner.nextInt();
        truckArrayList.get(position).getBasicForm().setPrice(newPrice);

        System.out.println("Nova cena auta je: " + truckArrayList.get(position).getBasicForm().getPrice());
    }

    private void modifyTruckType(int position, String truckName){
        String newTruckType;

        System.out.println("Zadajte novy typ auta: " + truckName);
        newTruckType = scanner.nextLine();
        truckArrayList.get(position).getBasicForm().setType(newTruckType);

        System.out.println("Novy typ auta je: " + truckArrayList.get(position).getBasicForm().getType());
    }

    public void modifyTruck(String truckName){
        int position = findTruckByName(truckName);
        int choice = 0;
        boolean quit = false;

        if(position >= 0){
            while (!quit){
                System.out.println("Zadajte vlastnost ktoru chcete editovat v nakladnom aute: " + truckName);
                printModifyInstructions();
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 0:
                        printModifyInstructions();
                        break;
                    case 1:
                        modifyTryckName(position, truckName);
                        break;
                    case 2:
                        modifyTruckPrice(position, truckName);
                        break;
                    case 3:
                        modifyTruckType(position, truckName);
                    case 4:
                        quit = true;
                        break;
                }
            }
        }
    }
}
