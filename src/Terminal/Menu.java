package Terminal;

import Finances.Finances;
import Locales.Messages;

import java.util.Scanner;

public class Menu extends Messages {
    private static Scanner scanner = new Scanner(System.in);
    private static Finances finances = new Finances();
    private static Autobazar autobazar;

    private final int startingCapital = 1000;

    public void createDialog(){
        boolean quit = false;
        setBudget();

        while(!quit){
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
                    getBudget();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
    }

    private void mainDialog(){
        System.out.println("\n Press");
        System.out.println("\t 0 - Nové autá");
        System.out.println("\t 1 - Autobazár");
        System.out.println("\t 2 - Financie");
        System.out.println("\t 3 - Ukončiť aplikáciu");
    }

    protected int scanInput(){
        int choice = -1;
        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt){
            choice = scanner.nextInt();
        }

        scanner.nextLine();
        return choice;
    }

    protected void setBudget(int price){
        finances.income(price);
    }

    private void setBudget(){
        finances.setBudget(startingCapital);
    }

    protected void getBudget(){
        System.out.println("Aktualny stav financii: " + finances.getBudget());
    }
}
