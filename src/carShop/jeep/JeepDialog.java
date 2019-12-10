package carShop.jeep;

import car.CarTypes;
import carShop.CarShop;

import java.util.Scanner;

public class JeepDialog extends CarShop {
    private static Scanner scanner = new Scanner(System.in);
    private CarTypes carTypes;

    public JeepDialog(CarTypes carTypes) {
        this.carTypes = carTypes;
    }

    public void jeepDialog(){
        boolean quit = false, hasNextInt;
        int choice = 0;
        while(!quit){
            System.out.println("Vyberte model znacky Jeep o ktory  mate zaujem.");
            carTypes.printModelsOfCarBrand("jeep");

            hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice){
                case 0:
                    if(carTypes.areYouSure("Jeep","Cherokee 4x4", 41000)){
                        Jeep jeep = new Jeep("Cherokee 4x4", 5, 41000, true);
                        Jeep.Has4x4 has4x4 = jeep.new Has4x4();
                        has4x4.checkHas4x4();
                        if(has4x4.getCheckOf4x4()){
                            System.out.println("GREAT! Your Jeep has also 4x4");
                        }
                        System.out.println(jeep.created());
                        setBudget(41000);
                    }
                    break;
                case 1:
                    if(carTypes.areYouSure("Jeep","Wrangler", 35000)){
                        Jeep jeep = new Jeep("Wrangler", 5, 35000, false);
                        System.out.println(jeep.created());
                        setBudget(35000);
                    }
                    break;
                case 2:
                    if(carTypes.areYouSure("Jeep","C-Compass", 30000)){
                        Jeep jeep = new Jeep("C-Compass", 5, 30000, true);
                        System.out.println(jeep.created());
                        setBudget(30000);
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
