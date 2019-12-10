package terminal;

import autobazar.Autobazar;
import carShop.CarShop;
import finances.Finances;
import locales.Messages;

import java.util.Scanner;

public class Menu extends Messages {
    private static Scanner scanner = new Scanner(System.in);
    private static Finances finances = new Finances();
    private static Autobazar autobazar;
    private static CarShop carShop;
    final int startingCapital = 1000;

    public void createDialog(){
        boolean quit = false;
        setStartingBudget();

        while(!quit){
            mainDialog();
            switch (scanInput()) {
                case 0:
                    carShop = new CarShop();
                    carShop.dialog();
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
        System.out.println("\t 1 - " + getLanguages().get("test"));
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

    protected void setBudget(int income){
        finances.income(income);
    }

    private void setStartingBudget(){
        finances.setBudget(startingCapital);
    }

    private void getBudget(){
        System.out.println("Aktualny stav financii: " + finances.getBudget());
    }
}
