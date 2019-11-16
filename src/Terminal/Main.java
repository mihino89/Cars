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
             System.out.println("Enter your choice");
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
//                 case 5:
//                     searchForItem();
//                     break;
                 case 6:
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
//        System.out.println("\t 6 - To search");
        System.out.println("\t 6 - To quit app");
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

        if(whichCase.equals("remove")){
            System.out.println(getMessages(1));
        } else if (whichCase.equals("buy")) {
            System.out.println(getMessages(2));
        }
        carName = scanner.nextLine();

        return carName;
    }

    private static void toRemoveCar(){
        int chooseCategory = cattegory();

        if(chooseCategory == 1){
            String carName = getCarName("remove");
            personalCarList.removeCar(carName, getMessages(3));
        } else {
            System.out.println(getMessages(0));
        }
    }


    public static void buyCar(){
        int chooseCategory = cattegory();
        int price;

        if(chooseCategory == 1){
            String carName = getCarName("buy");
            price = personalCarList.buyCar(carName, getMessages(3));
            finances.income(price);
        } else if(chooseCategory == 0){
            System.out.println("Chcem kupit nakladne auto");
        } else {
            System.out.println(getMessages(0));
        }
    }


//    public static void modifyItem(){
//        System.out.println("Enter item name: ");
//        String ItemNo = scanner.nextLine();
//        System.out.println("Enter replacement item: ");
//        String newItem = scanner.nextLine();
//        personalCarList.modifyGroceryItem(ItemNo, newItem);
//    }
//
//    public static void searchForItem(){
//        System.out.println("Item to search for: ");
//        String searchItem = scanner.nextLine();
//
//        if(personalCarList.onFile(searchItem)){
//            System.out.println("Found " + searchItem + " in glocary list");
//        } else {
//            System.out.println(searchItem + " was didnt find");
//        }
//    }


    //polymorfizmus, dedenie, overloading , overvriting

}
