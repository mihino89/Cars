package forms;

import trucks.Truck;

import java.util.Scanner;

public class TruckForm {
    private int maxWeight;
    private boolean hasSemiTrailer;
    private int choice;
    private BasicForm basicForm;

    private static Scanner scanner = new Scanner(System.in);

    private boolean hasTrailer(){
        this.choice = scanner.nextInt();

        if(this.choice == 1){
            return true;
        }
        else if( this.choice == 0){
            return false;
        }
        System.out.println("Bola zadaná zlá hodnota. Ano (stlač 1)/ Nie (stlač 0)");
        return hasTrailer();
    }

    public Truck create(){
        System.out.println("Vitajte vo formulári pre pridanie nového nákladného auta");

        basicForm = new BasicForm();
        basicForm.create();

        System.out.println("Zadajte maximálnu zátaž nákladu");
        maxWeight = scanner.nextInt();

        System.out.println("Je k autu aj príves?");
        System.out.println("\tÁno: (stlač 1):");
        System.out.println("\tNie: (stlač 0):");
        hasSemiTrailer = hasTrailer();

        return new Truck(basicForm.getName(), basicForm.getType(), basicForm.getPassedKm(), basicForm.getWheels(),
                basicForm.getDoors(), basicForm.getPrice(), basicForm.isManual(), maxWeight, hasSemiTrailer);
    }


}
