package autobazar;

import forms.PersonalCarForm;
import forms.TruckForm;
import personalCar.IPersonalCarList;
import personalCar.PersonalCarList;
import terminal.Menu;
import trucks.ITruckList;
import trucks.TruckList;

import java.util.Scanner;

public class Autobazar extends Menu {
    private static Scanner scanner = new Scanner(System.in);
    private IPersonalCarList personalCarList = new PersonalCarList();
    private ITruckList truckList = new TruckList();

    public void dialog() {
         boolean quit = false, hasNextInt;
         int choice = 0;
         while(!quit){
             System.out.println("Vyberte si službu");
             printInstructions();
             hasNextInt = scanner.hasNextInt();
             if(hasNextInt){
                 choice = scanner.nextInt();
                 scanner.nextLine();

                 switch (choice){
                     case 0:
                         printInstructions();
                         break;
                     case 1:
                         printListOfCars();
                         break;
                     case 2:
                         addCar();
                         break;
                     case 3:
                         toRemoveCar();
                         break;
                     case 4:
                         buyCar();
                         break;
                     case 5:
                         modifyCarParams();
                         break;
                     case 6:
                         quit = true;
                         break;
                 }
             }
         }
    }


    private void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - Menu autobázaru");
        System.out.println("\t 1 - Vypísať autá");
        System.out.println("\t 2 - Pridať nové auto na predaj");
        System.out.println("\t 3 - Vymazať auto podla značky");
        System.out.println("\t 4 - Kúpiť auto");
        System.out.println("\t 5 - Modifikovať parametre auta");
        System.out.println("\t 6 - Prejsť na hlavné menu");
    }


    @Override
    protected int scanInput() {
        int chooseCattegory = -1;

        System.out.println("Zadajte typ auta:");
        System.out.println("\tMenej ako 3,5t: (stlač 1):");
        System.out.println("\tViac ako 3,5t: (stlač 0):");
        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt){
            chooseCattegory = scanner.nextInt();
        }

        scanner.nextLine();
        return chooseCattegory;
    }


    private void printListOfCars(){
        int chooseCattegory = scanInput();

        if(chooseCattegory == 1){
            personalCarList.printCarList();
        } else if(chooseCattegory == 0){
            truckList.printTruckList();
        } else {
            System.out.println(getMessages(0));
        }
    }


    private void addCar(){
        int chooseCattegory = scanInput();

        if( chooseCattegory == 1){
            PersonalCarForm personalCarForm = new PersonalCarForm();
            personalCarList.addCar(personalCarForm.create());
        } else if( chooseCattegory == 0){
            TruckForm truckForm = new TruckForm();
            truckList.addTruck(truckForm.create());
        } else{
            System.out.println(getMessages(0));
        }
    }


    private String getVehicleName(String whichCase){
        String vehicleName;

        switch (whichCase){
            case "remove":
                System.out.println(getMessages(1));
                break;
            case "buy":
                System.out.println(getMessages(2));
                break;
            case "modify":
                System.out.println(getMessages(3));
                break;
        }
        vehicleName = scanner.nextLine();

        return vehicleName;
    }

    private void toRemoveCar(){
        int chooseCategory = scanInput();

        String vehicleName = getVehicleName("remove");
        if(chooseCategory == 1){
            personalCarList.removeCar(vehicleName, getMessages(4));
        } else {
            truckList.removeTruck(vehicleName, getMessages(4));
        }
    }


    private void buyCar(){
        int chooseCategory = scanInput();
        int price = -1;
        String vehicleName;

        vehicleName = getVehicleName("buy");
        if(chooseCategory == 1){
            price = personalCarList.buyCar(vehicleName, getMessages(4));
        } else if(chooseCategory == 0){
            price = truckList.buyTruck(vehicleName, getMessages(4));
        } else {
            System.out.println(getMessages(0));
        }

        if(price >= 0){
            setBudget(price);
        }
    }


    private void modifyCarParams(){
        int chooseCategory = scanInput();
        String vehicleName;

        vehicleName = getVehicleName("modify");
        if(chooseCategory == 1){
            personalCarList.modifyCar(vehicleName);
        } else if(chooseCategory == 0){
            truckList.modifyTruck(vehicleName);
        }
    }

    //polymorfizmus, dedenie, overloading , overvriting
    // moznost vytvorenia noveho auta - vylepsenie kompozicie - komponenty dvere, palubna doska
}
