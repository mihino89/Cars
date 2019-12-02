package carShop;

import car.CarTypes;
import carShop.ford.FordDialog;
import carShop.jeep.JeepDialog;
import carShop.saab.SaabDialog;
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
                    FordDialog fordDialog = new FordDialog(carTypes);
                    fordDialog.fordDialog();
                    break;
                case 3:
                    JeepDialog jeepDialog = new JeepDialog(carTypes);
                    jeepDialog.jeepDialog();
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
        System.out.println("\t 1 - saab");
        System.out.println("\t 2 - ford");
        System.out.println("\t 3 - Jeep");
        System.out.println("\t 4 - Spať na hlavné menu");
    }
}
