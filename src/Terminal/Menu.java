package Terminal;

import Finances.Finances;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Finances finances = new Finances();
    private static Autobazar autobazar;


    public void createDialog(){
        finances.setBudget(1000);

        mainDialog();
        switch (scanInput()) {
            case 0:
                System.out.println("ahooj");
                break;
            case 1:
                autobazar = new Autobazar();
                autobazar.dialog();
                break;
            case 2:
                System.out.println("Your budget is: " + finances.getBudget());
        }
    }

    private void mainDialog(){
        System.out.println("\n Press");
        System.out.println("\t 0 - Nové autá");
        System.out.println("\t 1 - Autobazár");
        System.out.println("\t 2 - Financie");
    }

    private int scanInput(){
        int choice = -1;
        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt){
            choice = scanner.nextInt();
        }

        scanner.nextLine();
        return choice;
    }
}
