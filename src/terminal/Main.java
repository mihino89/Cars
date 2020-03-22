package terminal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
    private static Menu menu;
    Button button;

    public static void main(String[] args) {
        launch(args); // set up as javafx app
        menu = new Menu();
        menu.createDialog();
    }

    @Override
    public void start(Stage stage) throws Exception {
//         main javafx code
        stage.setTitle("title of the windows");

        button = new Button();
        button.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();

    }
}
