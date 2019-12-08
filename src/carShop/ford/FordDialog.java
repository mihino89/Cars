package carShop.ford;

import car.Car;
import car.CarTypes;
import carShop.CarShop;

import java.util.Scanner;

public class FordDialog extends CarShop {
    private CarTypes carTypes;
    private static Scanner scanner = new Scanner(System.in);
    private int counter;

    public FordDialog(CarTypes carTypes, int counter) {
        this.carTypes = carTypes;
        this.counter = counter;
    }

    public void fordDialog(){
        boolean quit = false, hasNextInt;
        int choice = 0;
        while(!quit){
            System.out.println("Vyberte model znacky Ford o ktory mate zaujem.");
            carTypes.printModelsOfCarBrand("ford");

            hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            switch (choice){
                case 0:
                    if(carTypes.areYouSure("Ford","Fiesta", 12000)){
                        Ford ford = new Ford("Fiesta", 3, 12000, true);
                        Car car = ford;
                        System.out.println(car.created());
                        setBudget(12000);
                    }
                    break;
                case 1:
                    if(getCounter() < 2){
                        if(carTypes.areYouSure("Ford","Focus", 24000)){
                            Ford ford = new Ford("Focus", 5, 24000, false);
                            Car car = (Car) ford;
                            System.out.println(car.created());
                            addCounter();
                            setBudget(24000);
                        }
                    } else {
                        System.out.println("Ford focus je docastne vypredany");
                        carTypes.deleteModel(1);
                    }
                    break;
                case 2:
                    if(carTypes.areYouSure("Ford","C-MAX", 19000)){
                        Ford ford = new Ford("C-MAX", 4, 19000, true);
                        System.out.println(ford.created());
                        setBudget(19000);
                    }
                    break;
                case 3:
                    if(carTypes.areYouSure("Ford","Kuga", 34000)){
                        Ford ford = new Ford("Kuga", 5, 34000, true);
                        System.out.println(ford.created());
                        setBudget(34000);
                    }
                    break;
                case 4:
                    if(carTypes.areYouSure("Ford","Mondeo", 27000)){
                        Ford ford = new Ford("Mondeo", 3, 27000, true);
                        System.out.println(ford.created());
                        setBudget(27000);
                    }
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println(getMessages(0));
            }
        }
    }
}
