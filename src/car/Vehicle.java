package car;

public class Vehicle {
    private String name;
    private String type;
    private int passedKm;

    public Vehicle(String name, String type, int passedKm) {
        this.name = name;
        this.type = type;
        this.passedKm = passedKm;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPassedKm() {
        return passedKm;
    }

    public void setPassedKm(int passedKm) {
        this.passedKm = passedKm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
