package personalCar;

public interface IPersonalCarList {
    public void addCar(PersonalCar personalCar);
    public void printCarList();
    public void removeCar(String carName, String errorMessage);
    public int buyCar(String carName, String errorMessage);
    public void modifyCar(String carName);
}
