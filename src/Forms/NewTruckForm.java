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
        System.out.println("Zadana zla hodnota. Ano (press 1)/ Nie (press 0)");
        return hasTrailer();
    }

    public Truck create(){
        System.out.println("Welcome in add car form");

        this.basicForm = new BasicForm();
        basicForm.create();

        System.out.println("Zadajte maximalnu zataz nakladu");
        this.maxWeight = scanner.nextInt();

        System.out.println("Je k autu aj prives?");
        System.out.println("\tAno: (press 1):");
        System.out.println("\tNie: (press 0):");
        this.hasSemiTrailer = hasTrailer();

        return new Truck(basicForm.getName(), basicForm.getType(), basicForm, this.maxWeight, this.hasSemiTrailer);
    }
}
