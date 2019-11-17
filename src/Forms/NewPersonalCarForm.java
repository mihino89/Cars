package Forms;

import PersonalCar.PersonalCar;

import java.util.Scanner;

public class NewPersonalCarForm{
    private boolean forChildren;
    private BasicForm basicForm;

    public NewPersonalCarForm() {
        this.forChildren = forChildren;
        this.basicForm = basicForm;
    }

    private static Scanner scanner = new Scanner(System.in);


    public PersonalCar create() {
        int choice;

        System.out.println("Welcome in add car form");

        //kompozicia
        this.basicForm = new BasicForm();
        basicForm.create();

        System.out.println("Zadajte ci je auto vhode pre deti:");
        System.out.println("\tAno: (press 1):");
        System.out.println("\tNie: (press 0):");
        choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1){
            this.forChildren = true;
        } else{
            this.forChildren = false;
        }

        return new PersonalCar(basicForm.getName(), basicForm.getType(), basicForm, this.forChildren);
    }
}
