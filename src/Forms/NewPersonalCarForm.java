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

        System.out.println("Vitajte vo formulári pre pridanie nového auta");

        //kompozicia
        this.basicForm = new BasicForm();
        basicForm.create();

        System.out.println("Zadajte či je auto vhodné pre deti:");
        System.out.println("\tÁno: (stlačte 1):");
        System.out.println("\tNie: (stlačte 0):");
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