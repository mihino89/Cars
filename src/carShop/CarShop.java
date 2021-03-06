package carShop;

import car.Car;
import car.CarTypes;
import carShop.custom.CustomCar;
import carShop.ford.FordDialog;
import carShop.jeep.JeepDialog;
import carShop.saab.SaabDialog;
import forms.BasicForm;
import personalCar.PersonalCar;
import terminal.Menu;

import java.util.Scanner;

public class CarShop extends Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static CarTypes carTypes = new CarTypes();
    private static int counter = 0;

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
                    FordDialog fordDialog = new FordDialog(carTypes, counter);
                    fordDialog.fordDialog();
                    break;
                case 3:
                    JeepDialog jeepDialog = new JeepDialog(carTypes);
                    jeepDialog.jeepDialog();
                    break;
                case 4:
                    BasicForm basicForm = new BasicForm();
                    basicForm.create();
                    CustomCar customCar = new CustomCar(basicForm.getName(), basicForm.getType(),
                            basicForm.getPassedKm(), basicForm.getWheels(), basicForm.getDoors(), basicForm.getPrice(),
                            basicForm.isManual(), true);
                    PersonalCar personalCar = customCar;
                    if(personalCar instanceof PersonalCar){
                        CustomCar customCar1 = (CustomCar) personalCar;
                        System.out.println(customCar1.created());
                    }
                case 5:
                    quit = true;
                    break;
            }
        }
    }

    public static void addCounter() {
        CarShop.counter ++;
    }

    public static int getCounter() {
        return counter;
    }

    private void printInstructions() {
        System.out.println("\n Press");
        System.out.println("\t 0 - Menu predajne");
        System.out.println("\t 1 - Saab");
        System.out.println("\t 2 - Ford");
        System.out.println("\t 3 - Jeep");
        System.out.println("\t 4 - Ine");
        System.out.println("\t 5 - Spať na hlavné menu");
    }
}
