package pl.weatherApp.view;

import javafx.stage.Stage;

public class ViewFactory {
    public static void createMainView(Stage primaryStage){
        MainView.showMainWindow(primaryStage);
    }
}
