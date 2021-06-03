package controller;

import javafx.application.Platform;
import model.Notificaton;
import view.DeviceScene;
import view.EmulatorScene;
import view.HistoryScene;
import view.MainScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    public static MainScene mainScene = new MainScene();
    public static DeviceScene deviceScene = new DeviceScene();
    public static HistoryScene historyScene = new HistoryScene();
    public static EmulatorScene emulatorScene = new EmulatorScene();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("controller.fxml"));

        primaryStage.setTitle("SimpliSafe Application [WIP]");
        primaryStage.setScene(new Scene(initTabPane(), 800, 600));
        primaryStage.show();
    }

    public TabPane initTabPane() {
        TabPane mainPane = new TabPane();
        Tab tab1 = new Tab("Main", mainScene.getPane());
        tab1.setClosable(false);

        Tab tab2 = new Tab("History", historyScene.getPane());
        tab2.setClosable(false);

        Tab tab3 = new Tab("Device", deviceScene.getPane());
        tab3.setClosable(false);

        Tab tab4 = new Tab("Emulator", emulatorScene.getPane());
        tab4.setClosable(false);

        mainPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        return mainPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
