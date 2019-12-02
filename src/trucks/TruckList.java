package trucks;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckList implements ITruckList {
    private ArrayList<Truck> truckArrayList = new ArrayList<Truck>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void addTruck(Truck truck){
        truckArrayList.add(truck);
    }

    @Override
    public void printTruckList(){
        System.out.println("Počet nájdených nákladných áut v databáze: " + truckArrayList.size());
        String hasSemiTrailer;

        for(int i = 0; i < truckArrayList.size(); i++){
            if(truckArrayList.get(i).isHasSemiTrailer()){
                hasSemiTrailer = "áno";
            } else {
                hasSemiTrailer = "nie";
            }
            System.out.println((i + 1) +
            ". Značka: " + truckArrayList.get(i).getName() +
            ", Typ: " + truckArrayList.get(i).getType() +
            ", Počet kolies: " + truckArrayList.get(i).getWheels() +
            ", Počet dverí je: " + truckArrayList.get(i).getDoors() +
            ", Maximálna zátaž vozidla: " + truckArrayList.get(i).getMaxWeight() +
            ", Má príves: " + hasSemiTrailer
            );
        }
    }

    private int findTruckByName(String searchedCar){
        for(int i = 0; i < truckArrayList.size(); i++){
            if(searchedCar.equals(truckArrayList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    private void removeTruck(int position){
        truckArrayList.remove(position);
    }

    @Override
    public void removeTruck(String truckName, String errorMessage){
        int position = findTruckByName(truckName);

        if(position >= 0){
            removeTruck(position);
            System.out.println("Nákladne auto " + truckName + " bolo úspešne vymazané");
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public int buyTruck(String truckName, String errorMessage){
        int position = findTruckByName(truckName);
        int price = -1;

        if(position >= 0){
            price = truckArrayList.get(position).getPrice();
            removeTruck(position);
            return price;
        }

        System.out.println(errorMessage);
        return price;
    }

    private void printModifyInstructions(){
        System.out.println("\t 0 - Vypísať menu pre modifikovanie nákladneho auta");
        System.out.println("\t 1 - Modifikovat názov nákladneho auta");
        System.out.println("\t 2 - Modifikovat cenu nákladneho auta");
        System.out.println("\t 3 - Modifikovat typ nákladneho auta");
        System.out.println("\t 4 - Modifikovat maximálnu zátaž nákladneho auta");
        System.out.println("\t 5 - Ukončit modifikaciu nákladneho auta");
    }

    private void modifyTryckName(int position, String truckName){
        String newTruckName;

        System.out.println("Zadajte nový názov nákladného auta: " + truckName);
        newTruckName = scanner.nextLine();
        truckArrayList.get(position).setName(newTruckName);
        System.out.println("Nový názov nákladného auta je: " + truckArrayList.get(position).getName());
    }

    private void modifyTruckPrice(int position, String truckName){
        int newPrice;

        System.out.println("Zadajte novú cenu nákladného auta: " + truckName);
        newPrice = scanner.nextInt();
        truckArrayList.get(position).setPrice(newPrice);

        System.out.println("Nová cena nákladného auta je: " + truckArrayList.get(position).getPrice());
    }

    private void modifyTruckType(int position, String truckName){
        String newTruckType;

        System.out.println("Zadajte nový typ nákladného auta: " + truckName);
        newTruckType = scanner.nextLine();
        truckArrayList.get(position).setType(newTruckType);

        System.out.println("Nový typ nákladného auta je: " + truckArrayList.get(position).getType());
    }

    private void modifyMaxWeight(int position, String truckName){
        int newMaxWeight;

        System.out.println("Zadajte novú maximálnu zátaž nákladného auta: " + truckName);
        newMaxWeight = scanner.nextInt();
        scanner.nextLine();
        truckArrayList.get(position).setMaxWeight(newMaxWeight);

        System.out.println("Nová maximálna záťaž nákladného auta je: " + truckArrayList.get(position).getMaxWeight());
    }

    @Override
    public void modifyTruck(String truckName){
        int position = findTruckByName(truckName);
        int choice = 0;
        boolean quit = false;

        if(position >= 0){
            while (!quit){
                System.out.println("Zadajte vlastnosť ktorú chcete editovať v nákladnom aute: " + truckName);
                printModifyInstructions();
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 0:
                        printModifyInstructions();
                        break;
                    case 1:
                        modifyTryckName(position, truckName);
                        break;
                    case 2:
                        modifyTruckPrice(position, truckName);
                        break;
                    case 3:
                        modifyTruckType(position, truckName);
                        break;
                    case 4:
                        modifyMaxWeight(position, truckName);
                        break;
                    case 5:
                        quit = true;
                        break;
                }
            }
        }
    }
}
