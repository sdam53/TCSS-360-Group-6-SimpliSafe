package controller;

import view.DeviceScene;
import view.EmulatorScene;
import view.HistoryScene;
import view.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Main class that handles the main function
 */
public class Main extends Application {

    //all the scenes are static to allow easier changes
    public static MainScene mainScene = new MainScene();
    public static DeviceScene deviceScene = new DeviceScene();
    public static HistoryScene historyScene = new HistoryScene();
    public static EmulatorScene emulatorScene = new EmulatorScene();

    /**
     * sets the primary stage to the TabPane
     * @param primaryStage the stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("SimpliSafe Application [WIP]");
        Scene rootScene = new Scene(initTabPane(), 800, 600);
        rootScene.getStylesheets().add("/view.css");
        primaryStage.setScene(rootScene);
        primaryStage.show();
    }

    /**
     * init function for the main TabPane which is here to reduce clutter in main
     * @return tabpane
     */
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

    public static void main(String[] args) { launch(args); }
}
