package car;

import java.util.Scanner;

public class CarTypes {
    private static Scanner scanner = new Scanner(System.in);

    private String[] brand = new String[]{
        "Saab",
        "Ford",
        "Jeep"
    };

    private String[] saab = new String[]{
        "Aero-X",
        "9-5",
        "PhoeniX"
    };

    private String[] ford = new String[]{
        "Fiesta",
        "Focus",
        "C-MAX",
        "Kuga",
        "Mondeo"
    };

    private String[] jeep = new String[]{
        "Cherokee 4x4",
        "Wrangler",
        "Compass",
    };

    private void press(){
        System.out.println("\tAno: (stlač 1):");
        System.out.println("\tNie: (stlač 0):");
    }

    public void deleteModel(int index){
        for(int i = 0; i <= index; i++){
            if(i == index){
                for(int j = i; j < index; j++){
                    ford[j] = ford[j+1];
                }
                break;
            }
        }
    }

    private String[] recognizeCarBrand(String carBrand){
        switch (carBrand){
            case "ford":
                return ford;
            case "saab":
                return saab;
            case "jeep":
                return jeep;
        }
        return null;
    }

    public void printModelsOfCarBrand(String selectedBrand){
        String[] arr;
        int i;

        arr = recognizeCarBrand(selectedBrand);

        for(i = 0; i < arr.length; i++){
            System.out.println(i + ". " + arr[i]);
        }
        System.out.println(i + ". " + " Spat na menu obchodu s autami");
    }

    public boolean areYouSure(String carBrand, String carModel, int price){
        int chooseCattegory = -1;

        System.out.println("Naozaj chcete kupit auto" + carBrand + ", " + carModel + " for " + price + " eur ?");
        press();
        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt){
            chooseCattegory = scanner.nextInt();
            if(chooseCattegory == 1){
                scanner.nextLine();
                return true;
            } else if(chooseCattegory == 0){
                scanner.nextLine();
                return false;
            }
            else {
                areYouSure(carBrand, carModel, price);
            }
        }

        return false;
    }

    public boolean testinDrive(){
        boolean hasNextInt;
        int choice = -1;

        System.out.println("Chcete vyskusat auto na testovacej jazde?");
        press();
        hasNextInt = scanner.hasNextInt();
        if(hasNextInt){
            choice = scanner.nextInt();
        }
        if(choice == 1){
            return true;
        }

        return false;
    }

    public int testingDrive(){
        int lengtOfTestingDrive = 0;

        System.out.println("How many kilometers do you want testing drive?");
        lengtOfTestingDrive = scanner.nextInt();

        return lengtOfTestingDrive;
    }
}
