package PersonalCar;

import Forms.BasicForm;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonalCarList {
    private ArrayList<PersonalCar> personalCarArrayList = new ArrayList<PersonalCar>();
    private static Scanner scanner = new Scanner(System.in);

    //Asociacia
    public void addCar(PersonalCar personalCar){
        personalCarArrayList.add(personalCar);
    }

    public void printCarList(){
        System.out.println("Finded " + personalCarArrayList.size() + " cars in autobazar database");
        for(int i = 0; i < personalCarArrayList.size(); i++){
            System.out.println((i + 1) + ". Name " + personalCarArrayList.get(i).getBasicForm().getName() +
            " Type is: " + personalCarArrayList.get(i).getBasicForm().getType() + ", is for children: " +
            personalCarArrayList.get(i).isForChildren() + ", price is: " +
            personalCarArrayList.get(i).getBasicForm().getPrice());
        }
    }

    private int findCarByName(String searchedCar){
        for(int i = 0; i < personalCarArrayList.size(); i++){
            if(searchedCar.equals(personalCarArrayList.get(i).getBasicForm().getName())){
                return i;
            }
        }
        return -1;
    }

    // overloading
    private void removeCar(int position){
        personalCarArrayList.remove(position);
    }

    public void removeCar(String carName, String errorMessage){
        int position = findCarByName(carName);

        if(position >= 0){
            removeCar(position);
            System.out.println("Auto " + carName + " bolo uspesne vymazane");
        } else {
            System.out.println(errorMessage);
        }
    }

    public int buyCar(String carName, String errorMessage){
        int position = findCarByName(carName);
        int price = -1;

        if(position >= 0){
            price = personalCarArrayList.get(position).getBasicForm().getPrice();
            removeCar(position);
            return price;
        }

        System.out.println(errorMessage);
        return price;
    }


    private void printModifyInstructions(){
        System.out.println("\t 0 - Vypisat menu pre modifikovanie auta");
        System.out.println("\t 1 - Modifikovat nazov auta");
        System.out.println("\t 2 - Modifikovat cenu auta");
        System.out.println("\t 3 - Modifikovat typ auta");
        System.out.println("\t 4 - Ukoncit modifikaciu auta");
    }

    private void modifyCarName(int position, String carName){
        String newCarName;

        System.out.println("Zadajte novy nazov auta: " + carName);
        newCarName = scanner.nextLine();
        personalCarArrayList.get(position).getBasicForm().setName(newCarName);
        System.out.println("Novy nazov auta je: " + personalCarArrayList.get(position).getBasicForm().getName());
    }

    private void modifyCarPrice(int position, String carName){
        int newPrice;

        System.out.println("Zadajte novu cenu auta: " + carName);
        newPrice = scanner.nextInt();
        personalCarArrayList.get(position).getBasicForm().setPrice(newPrice);

        System.out.println("Nova cena auta je: " + personalCarArrayList.get(position).getBasicForm().getPrice());
    }

    private void modifyCarType(int position, String carName){
        String newCarType;

        System.out.println("Zadajte novy typ auta: " + carName);
        newCarType = scanner.nextLine();
        personalCarArrayList.get(position).getBasicForm().setType(newCarType);

        System.out.println("Novy typ auta je: " + personalCarArrayList.get(position).getBasicForm().getType());
    }

    public void modifyCar(String carName){
        int position = findCarByName(carName);
        int choice = 0;
        boolean quit = false;

        if(position >= 0){
            while (!quit){
                System.out.println("Zadajte vlastnost ktoru chcete editovat v aute: " + carName);
                printModifyInstructions();
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 0:
                        printModifyInstructions();
                        break;
                    case 1:
                        modifyCarName(position, carName);
                        break;
                    case 2:
                        modifyCarPrice(position, carName);
                        break;
                    case 3:
                        modifyCarType(position, carName);
                    case 4:
                        quit = true;
                        break;
                }
            }
        }
    }
}
