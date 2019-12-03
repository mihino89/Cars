package car;

public abstract class Car extends Vehicle {
    private int wheels;
    private int doors;
    private int price;
    private boolean isManual;

    public Car(String name, String type, int passedKm, int wheels, int doors, int price, boolean isManual) {
        super(name, type, passedKm);
        this.wheels = wheels;
        this.doors = doors;
        this.price = price;
        this.isManual = isManual;
    }

    public abstract void move(int km);

    public String created(){
        return "car was created.";
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

    public void setPrice(int price) {
        this.price = price;
    }
}