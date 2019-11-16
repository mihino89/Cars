package Car;

import Forms.BasicForm;

public class Car extends Vehicle {

    private BasicForm basicForm;

    public Car(String name, String type, BasicForm basicForm) {
        super(name, type);
        this.basicForm = basicForm;
    }

    public void changeVelocity(int speed, int direction){
        move(speed, direction);
        System.out.println("Car.changeVelocityt() : Velocity: " + speed + " direction " + direction);
    }
}