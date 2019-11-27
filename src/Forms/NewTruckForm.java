package Forms;

import Trucks.Truck;

import java.util.Scanner;

public class NewTruckForm {
    private int maxWeight;
    private boolean hasSemiTrailer;
    private int choice;
    private BasicForm basicForm;

    public NewTruckForm() {
        this.maxWeight = maxWeight;
        this.hasSemiTrailer = hasSemiTrailer;
        this.choice = choice;
        this.basicForm = basicForm;
    }

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

        this.basicForm = new BasicForm();
        basicForm.create();

        System.out.println("Zadajte maximálnu zátaž nákladu");
        this.maxWeight = scanner.nextInt();

        System.out.println("Je k autu aj príves?");
        System.out.println("\tÁno: (stlač 1):");
        System.out.println("\tNie: (stlač 0):");
        this.hasSemiTrailer = hasTrailer();

        return new Truck(basicForm.getName(), basicForm.getType(), basicForm.getWheels(),
                basicForm.getDoors(), basicForm.getPrice(), basicForm.isManual(), this.maxWeight, this.hasSemiTrailer);
    }


}
