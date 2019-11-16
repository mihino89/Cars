package Car;

import Forms.BasicForm;

public class Car extends Vehicle {

    private BasicForm basicForm;

    public Car(String name, String type, BasicForm basicForm) {
        super(name, type);
        this.basicForm = basicForm;
    }

    public BasicForm getBasicForm() {
        return this.basicForm;
    }
}