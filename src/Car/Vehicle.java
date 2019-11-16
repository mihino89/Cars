package Car;

public class Vehicle {
    private String name;
    private String type;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String type) {
        this.name = name;
        this.type = type;

        this.currentDirection = 0;
        this.currentVelocity = 0;
        // doplnit stav, ci je v pohybe alebo nie
    }

    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + this.currentDirection + " degrees");
    }

    public void move (int velocity, int direction){
        this.currentDirection = direction;
        this.currentVelocity = velocity;
        System.out.println("Vehicle.move(): Moving at: " + this.currentVelocity + " in direction " + this.currentDirection);
    }

    public void stop(){
        this.currentVelocity = 0;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
