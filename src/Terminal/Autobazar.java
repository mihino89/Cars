package Terminal;

import Finances.Finances;
import Forms.NewPersonalCarForm;
import Forms.NewTruckForm;
import Locales.Messages;
import PersonalCar.PersonalCarList;
import Trucks.TruckList;

import java.util.Scanner;

public class Autobazar extends Messages{
    private static Scanner scanner = new Scanner(System.in);
    // Agregacia
    private static PersonalCarList personalCarList = new PersonalCarList();
    private static TruckList truckList = new TruckList();
    // enkapsulacia - v main setBudget a v printBufget - getBudget
    private static Finances finances = new Finances(); // Finances budu v Main

    public void dialog() {
        finances.setBudget(1000);
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
                         printBudget();
                         break;
                     case 2:
                         printListOfCars();
                         break;
                     case 3:
                         addCar();
                         break;
                     case 4:
                         toRemoveCar();
                         break;
                     case 5:
                         buyCar();
                         break;
                     case 6:
                         modifyCarParams();
                         break;
                     case 7:
                         quit = true;
                         break;
                 }
             }
         }
    }


    public static void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - Menu autobázaru");
        System.out.println("\t 1 - Financie autobazáru");
        System.out.println("\t 2 - Vypísať autá");
        System.out.println("\t 3 - Pridať nové auto na predaj");
        System.out.println("\t 4 - Vymazať auto podla značky");
        System.out.println("\t 5 - Kúpiť auto");
        System.out.println("\t 6 - Modifikovať parametre auta");
        System.out.println("\t 7 - Ukončiť aplikáciu");
    }


    private static void printBudget(){
        System.out.println("Budget autobazáru je: " + finances.getBudget());
    }


    private static int cattegory(){
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


    public static void printListOfCars(){
        int chooseCattegory = cattegory();

        if(chooseCattegory == 1){
            personalCarList.printCarList();
        } else if(chooseCattegory == 0){
            truckList.printTruckList();
        } else {
            System.out.println(getMessages(0));
        }
    }


    public static void addCar(){
        int chooseCattegory = cattegory();

        if( chooseCattegory == 1){
            NewPersonalCarForm newPersonalCarForm = new NewPersonalCarForm();
            personalCarList.addCar(newPersonalCarForm.create());
        } else if( chooseCattegory == 0){
            NewTruckForm newTruckForm = new NewTruckForm();
            truckList.addTruck(newTruckForm.create());
        } else{
            System.out.println(getMessages(0));
        }
    }


    private static String getVehicleName(String whichCase){
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

    private static void toRemoveCar(){
        int chooseCategory = cattegory();

        String vehicleName = getVehicleName("remove");
        if(chooseCategory == 1){
            personalCarList.removeCar(vehicleName, getMessages(4));
        } else {
            truckList.removeTruck(vehicleName, getMessages(4));
        }
    }


    public static void buyCar(){
        int chooseCategory = cattegory();
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
            finances.income(price);
        }
    }


    public static void modifyCarParams(){
        int chooseCategory = cattegory();
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
