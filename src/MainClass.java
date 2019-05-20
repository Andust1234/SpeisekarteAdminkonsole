import controller.AdminScreenController;
import controller.LoginController;
import entitys.Dish;
import entitys.DishWrapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mock.MockGenerator;
//import sun.applet.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainClass extends Application {

    private Stage mainStage;

    private DishWrapper dishes;

    //opens Start Screen
    @Override
    public void start(Stage stage) {
        dishes = new DishWrapper(MockGenerator.generateDishes(20));
        mainStage = stage;
        showLogin();
    }

    //inflates Main Screen
    private void showAdminMenu() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/layout/AdminScreen.fxml"));
        AnchorPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AdminScreenController adminScreenController = loader.getController();
        adminScreenController.setStage(mainStage);
        adminScreenController.setLogoutListener(() -> {
            mainStage.close();
            showLogin();
        });
        adminScreenController.setDishes(dishes);
        Scene scene = new Scene(pane);
        mainStage.setScene(scene);
        mainStage.show();

    }

    private void showLogin() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/layout/Login.fxml"));
        AnchorPane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(pane);

        LoginController controller = loader.getController();
        controller.setLoginOkListener(isAdmin -> {
            mainStage.close();
            if (isAdmin) {
                showAdminMenu();
            } else {
                showMenu();
            }
        });

        mainStage.setScene(scene);
        mainStage.show();
    }

    public void showMenu() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}