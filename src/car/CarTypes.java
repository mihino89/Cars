package car;

import java.util.Scanner;

public class CarTypes {
    private static Scanner scanner = new Scanner(System.in);

    private String[] brand = new String[]{
        "saab",
        "ford",
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
        System.out.println("\tAno: (stlač 1):");
        System.out.println("\tNie: (stlač 0):");
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
}
