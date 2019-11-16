package Forms;

import java.util.Scanner;

public class BasicForm {
    private String name;
    private String type;
    private int wheels;
    private int doors;
    private boolean isManual;

    private static Scanner scanner = new Scanner(System.in);

    public BasicForm() {
        this.wheels = wheels;
        this.doors = doors;
        this.isManual = isManual;
    }

    public void create(){
        System.out.println("Zadajte nazov auta:");
        this.name = scanner.nextLine();

        System.out.println("Zadajte pocet sedadiel auta:");
        this.type = scanner.nextLine();

        System.out.println("Zadajte pocet kolies auta:");
        this.wheels = scanner.nextInt();

        System.out.println("Zadajte pocet dveri auta:");
        this.doors = scanner.nextInt();

        System.out.println("Zadajte typ prevodovky auta:");
        System.out.println("\tManual: (press 1):");
        System.out.println("\tAutomat: (press 0):");
        this.isManual = scanner.nextInt() == 1;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
