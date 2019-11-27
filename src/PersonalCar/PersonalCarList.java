package PersonalCar;

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
        System.out.println("Počet nájdených osobných áut v databáze: " + personalCarArrayList.size());
        String isForChildren;

        for(int i = 0; i < personalCarArrayList.size(); i++){
            if(personalCarArrayList.get(i).isForChildren()){
                isForChildren = "áno";
            } else {
                isForChildren = "nie";
            }
            System.out.println((i + 1) +
            ". Značka: " + personalCarArrayList.get(i).getName() +
            ", Typ je: " + personalCarArrayList.get(i).getType() +
            ", Počet kolies: " + personalCarArrayList.get(i).getWheels() +
            ", Počet dverí je: " + personalCarArrayList.get(i).getDoors() +
            ", Je pre deti: " + isForChildren +
            ", Cena je: " + personalCarArrayList.get(i).getPrice());
        }
    }

    private int findCarByName(String searchedCar){
        for(int i = 0; i < personalCarArrayList.size(); i++){
            if(searchedCar.equals(personalCarArrayList.get(i).getName())){
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
            System.out.println("Auto " + carName + " bolo úspešne vymazané");
        } else {
            System.out.println(errorMessage);
        }
    }

    public int buyCar(String carName, String errorMessage){
        int position = findCarByName(carName);
        int price = -1;

        if(position >= 0){
            price = personalCarArrayList.get(position).getPrice();
            removeCar(position);
            return price;
        }

        System.out.println(errorMessage);
        return price;
    }

    private void printModifyInstructions(){
        System.out.println("\t 0 - Vypísat menu pre modifikovanie auta");
        System.out.println("\t 1 - Modifikovať názov auta");
        System.out.println("\t 2 - Modifikovať cenu auta");
        System.out.println("\t 3 - Modifikovať typ auta");
        System.out.println("\t 4 - Ukončiť modifikáciu auta");
    }

    private void modifyCarName(int position, String carName){
        String newCarName;

        System.out.println("Zadajte nový názov auta: " + carName);
        newCarName = scanner.nextLine();
        personalCarArrayList.get(position).setName(newCarName);
        System.out.println("Nový názov auta je: " + personalCarArrayList.get(position).getName());
    }

    private void modifyCarPrice(int position, String carName){
        int newPrice;

        System.out.println("Zadajte novú cenu auta: " + carName);
        newPrice = scanner.nextInt();
        personalCarArrayList.get(position).setPrice(newPrice);

        System.out.println("Nová cena auta je: " + personalCarArrayList.get(position).getPrice());
    }

    private void modifyCarType(int position, String carName){
        String newCarType;

        System.out.println("Zadajte nový typ auta: " + carName);
        newCarType = scanner.nextLine();
        personalCarArrayList.get(position).setType(newCarType);

        System.out.println("Nový typ auta je: " + personalCarArrayList.get(position).getType());
    }

    public void modifyCar(String carName){
        int position = findCarByName(carName);
        int choice = 0;
        boolean quit = false;

        if(position >= 0){
            while (!quit){
                System.out.println("Zadajte vlastnosť ktorú chcete editovat v aute: " + carName);
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
