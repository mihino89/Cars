package PersonalCar;

import Locales.Messages;

import java.util.ArrayList;

public class PersonalCarList {
    private ArrayList<PersonalCar> personalCarArrayList = new ArrayList<PersonalCar>();
    private static Messages messages = new Messages();


    public void addCar(PersonalCar personalCar){
        personalCarArrayList.add(personalCar);
    }

    public void printCarList(){
        System.out.println("You have " + personalCarArrayList.size() + " items in your grocery list");
        for(int i = 0; i < personalCarArrayList.size(); i++){
            System.out.println((i + 1) + ". Name " + personalCarArrayList.get(i).getName() +
            " Type: " + personalCarArrayList.get(i).getType() + " and is for children: " +
            personalCarArrayList.get(i).isForChildren() + " and price is: " +
            personalCarArrayList.get(i).getBasicForm().getPrice());
        }
    }

    private int findCarByName(String searchedCar){
        for(int i = 0; i < personalCarArrayList.size(); i++){
            if(searchedCar.equals(personalCarArrayList.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    // overloading
    private void removeCar(int position){
        personalCarArrayList.remove(position);
    }

    public void removeCar(String carName){
        int position = findCarByName(carName);

        if(position >= 0){
            removeCar(position);
            System.out.println("Auto " + carName + " bolo uspesne vymazane");
        } else {
            System.out.println(messages.getMessages(2));
        }
    }



//    private void modifyGroceryItem(int position, String newItem){
//        personalCarArrayList.set(position, newItem);
//        System.out.println("Grocery item " + position+1 + " has been modified");
//    }
//
//    public void modifyGroceryItem(String currentItem, String newItem){
//        int position = findItem(currentItem);
//
//        if(position >= 0){
//            modifyGroceryItem(position, newItem);
//        }
//    }
//
//
//    public boolean onFile(String searchItem){
//        int position = findItem(searchItem);
//        if(position >= 0){
//            return true;
//        } else {
//            return false;
//        }
//    }
}
