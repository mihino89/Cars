package forms;

import java.util.Scanner;

public class BasicForm {
    private String name;
    private String type;
    private int wheels;
    private int doors;
    private int price;
    private boolean isManual;

    private static Scanner scanner = new Scanner(System.in);

    public BasicForm() {
        this.wheels = wheels;
        this.doors = doors;
        this.isManual = isManual;
        this.price = price;
    }

    public void create(){
        System.out.println("Zadajte značku vozidla:");
        this.name = scanner.next();
        scanner.nextLine();

        System.out.println("Zadajte typ auta:");
        this.type = scanner.nextLine();

        System.out.println("Zadajte počet kolies auta:");
        this.wheels = scanner.nextInt();

        System.out.println("Zadajte počet dverí auta:");
        this.doors = scanner.nextInt();

        System.out.println("Zadajte typ prevodovky auta:");
        System.out.println("\tManual: (stlačte 1):");
        System.out.println("\tAutomat: (stlačte 0):");
        this.isManual = scanner.nextInt() == 1;

        System.out.println("Zadajte cenu (v eurách) auta:");
        this.price = scanner.nextInt();
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

    public void setName(String name) {
        this.name = name;
    }
}
