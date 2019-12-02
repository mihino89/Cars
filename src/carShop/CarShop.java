package carShop;

import car.CarTypes;
import carShop.Saab.SaabDialog;
import terminal.Menu;

import java.util.Scanner;

public class CarShop extends Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static CarTypes carTypes = new CarTypes();

    public void dialog(){
        boolean quit = false, hasNextInt;
        int choice = 0;
        while(!quit){
            System.out.println("Vyberte znacku auta o ktore mate zaujem.");
            printInstructions();
            hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    SaabDialog saabDialog = new SaabDialog(carTypes);
                    saabDialog.saabDialog();
                    break;
                case 2:
//                    printModelsOfCarBrand("Ford");
                    break;
                case 3:
//                    printModelsOfCarBrand("Jeep");
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    private void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - Menu predajne");
        System.out.println("\t 1 - Saab");
        System.out.println("\t 2 - Ford");
        System.out.println("\t 3 - Jeep");
        System.out.println("\t 4 - Spať na hlavné menu");
    }
}
