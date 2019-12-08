package forms;

import java.util.Scanner;

public class BasicForm {
    private String name;
    private String type;
    private int passedKm;
    private int wheels;
    private int doors;
    private int price;
    private boolean isManual;

    private static Scanner scanner = new Scanner(System.in);

    public void create(){
        System.out.println("Zadajte značku vozidla:");
        name = scanner.next();
        scanner.nextLine();

        System.out.println("Zadajte typ auta:");
        type = scanner.nextLine();

        System.out.println("Zadajte pocet prejdenych kilometrov:");
        passedKm = scanner.nextInt();

        System.out.println("Zadajte počet kolies auta:");
        wheels = scanner.nextInt();

        System.out.println("Zadajte počet dverí auta:");
        doors = scanner.nextInt();

        System.out.println("Zadajte typ prevodovky auta:");
        System.out.println("\tManual: (stlačte 1):");
        System.out.println("\tAutomat: (stlačte 0):");
        isManual = scanner.nextInt() == 1;

        System.out.println("Zadajte cenu (v eurách) auta:");
        price = scanner.nextInt();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public int getPrice() {
        return price;
    }

    public boolean isManual() {
        return isManual;
    }

    public int getPassedKm() {
        return passedKm;
    }

    public void setName(String name) {
        name = name;
    }
}
