package car.Saab;

import car.CarTypes;

import java.util.Scanner;

public class SaabDialog extends CarTypes {
    private static Scanner scanner = new Scanner(System.in);

    public void saabDialog(){
        boolean quit = false, hasNextInt;
        int choice = 0;
        while(!quit){
            System.out.println("Vyberte model znacky Saab mate zaujem.");
            printModelsOfCarBrand("Saab");

            hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice){
                case 0:
                    System.out.println("Do you want buy it?");
                    Saab saab = new Saab("Aero-X", 5, 15000, true);
                    System.out.println(saab.created());
                    break;
                case 1:
                    System.out.println("choice 1");
                    break;
                case 2:
                    System.out.println("choice 2");
                    break;
                default:
                    System.out.println("invalid");
            }
        }
    }
}
