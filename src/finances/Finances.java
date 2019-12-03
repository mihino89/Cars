package finances;

public class Finances {
    private int budget;

    public Finances() {
        this.budget = budget;
    }

    public void income(int income){
        this.budget += income;
        System.out.println("Novy stav financii: " + this.budget);
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
