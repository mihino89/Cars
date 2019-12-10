package carShop.saab;

import car.CarTypes;
import carShop.CarShop;

import java.util.Scanner;

public class SaabDialog extends CarShop {
    private static Scanner scanner = new Scanner(System.in);
    private CarTypes carTypes;

    public SaabDialog(CarTypes carTypes) {
        this.carTypes = carTypes;
    }

    public void saabDialog(){
        boolean quit = false, hasNextInt;
        int choice = 0, lengtOfTestingDrive;
        while(!quit){
            System.out.println("Vyberte model znacky Saab o ktory mate zaujem.");
            carTypes.printModelsOfCarBrand("saab");

            hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice){
                case 0:
                    if(carTypes.testinDrive()){
                        Saab saab = new Saab("Aero-X", 3, 68000, true);
                        lengtOfTestingDrive = carTypes.testingDrive();
                        saab.move(lengtOfTestingDrive);
                        if(carTypes.areYouSure("saab","Aero-X", 68000)){
                            System.out.println(saab.created());
                            setBudget(68000);
                        }
                    } else {
                        if(carTypes.areYouSure("saab","Aero-X", 68000)){
                            Saab saab = new Saab("Aero-X", 3, 68000, true);
                            System.out.println(saab.created());
                            setBudget(68000);
                        }
                    }
                    break;
                case 1:
                    if(carTypes.testinDrive()){
                        Saab saab = new Saab("9-5", 5, 21000, false);
                        lengtOfTestingDrive = carTypes.testingDrive();
                        saab.move(lengtOfTestingDrive);
                        if(carTypes.areYouSure("saab","9-5", 21000)){
                            System.out.println(saab.created());
                            setBudget(21000);
                        }
                    } else {
                        if(carTypes.areYouSure("saab","9-5", 21000)){
                            Saab saab = new Saab("9-5", 5, 21000, false);
                            System.out.println(saab.created());
                            setBudget(21000);
                        }
                    }
                    break;
                case 2:
                    if(carTypes.testinDrive()){
                        Saab saab = new Saab("PhoeniX", 3, 85000, true);
                        lengtOfTestingDrive = carTypes.testingDrive();
                        saab.move(lengtOfTestingDrive);
                        if(carTypes.areYouSure("saab","PhoeniX", 85000)){
                            System.out.println(saab.created());
                            setBudget(85000);
                        }
                    } else {
                        if(carTypes.areYouSure("saab","PhoeniX", 85000)){
                            Saab saab = new Saab("PhoeniX", 3, 85000, true);
                            System.out.println(saab.created());
                            setBudget(85000);
                        }
                    }
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println(getLanguages().get("invalid"));
            }
        }
    }
}
