package Terminal;

import Finances.Finances;
import Forms.NewPersonalCarForm;
import Forms.NewTruckForm;
import Locales.Messages;
import PersonalCar.PersonalCarList;
import Trucks.TruckList;

import java.util.Scanner;

public class Main extends Messages{
    private static Scanner scanner = new Scanner(System.in);
    private static PersonalCarList personalCarList = new PersonalCarList();
    private static TruckList truckList = new TruckList();
    private static Finances finances = new Finances();


    public static void main(String[] args) {
         boolean quit = false;
         int choice = 0;
         printInstructions();
         while(!quit){
             System.out.println("Vyberte si sluzbu");
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


    public static void printInstructions(){
        System.out.println("\n Press");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To check budget");
        System.out.println("\t 2 - To print cars");
        System.out.println("\t 3 - To add a new car");
        System.out.println("\t 4 - To remove a car by name");
        System.out.println("\t 5 - To buy a car");
        System.out.println("\t 6 - To modify a car");
        System.out.println("\t 7 - To quit app");
    }


    private static void printBudget(){
        System.out.println("Budget autobazaru je: " + finances.getBudget());
    }


    private static int cattegory(){
        int chooseCattegory;

        System.out.println("Zadajte typy auta:");
        System.out.println("\tLess than 3,5t: (press 1):");
        System.out.println("\tMore than 3,5t: (press 0):");
        chooseCattegory = scanner.nextInt();
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


    private static String getCarName(String whichCase){
        String carName;

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
        carName = scanner.nextLine();

        return carName;
    }

    private static void toRemoveCar(){
        int chooseCategory = cattegory();

        if(chooseCategory == 1){
            String carName = getCarName("remove");
            personalCarList.removeCar(carName, getMessages(4));
        } else {
            System.out.println(getMessages(0));
        }
    }


    public static void buyCar(){
        int chooseCategory = cattegory();
        int price;
        String carName;

        if(chooseCategory == 1){
            carName = getCarName("buy");
            price = personalCarList.buyCar(carName, getMessages(4));
            if(price >= 0){
                finances.income(price);
            } else {
                System.out.println(getMessages(0));
            }
        } else if(chooseCategory == 0){
            System.out.println("Chcem kupit nakladne auto");
        } else {
            System.out.println(getMessages(0));
        }
    }


    public static void modifyCarParams(){
        int chooseCategory = cattegory();
        String carName;

        if(chooseCategory == 1){
            carName = getCarName("modify");
            personalCarList.modifyCar(carName);
        }
    }

    //polymorfizmus, dedenie, overloading , overvriting

}
