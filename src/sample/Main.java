package sample;

import View.DeviceScene;
import View.EmulatorScene;
import View.HistoryScene;
import View.MainScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("SimpliSafe Application [WIP]");
        primaryStage.setScene(new Scene(initTabPane(), 800, 600));
        primaryStage.show();
    }

    public TabPane initTabPane() {
        TabPane mainPane = new TabPane();
        Tab tab1 = new Tab("Main", new MainScene().getPane());
        tab1.setClosable(false);

        Tab tab2 = new Tab("History", new HistoryScene().getPane());
        tab2.setClosable(false);

        Tab tab3 = new Tab("Device", new DeviceScene().getPane());
        tab3.setClosable(false);

        Tab tab4 = new Tab("Emulator", new EmulatorScene().getPane());
        tab4.setClosable(false);

        mainPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        return mainPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
