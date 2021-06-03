package view;

import javafx.scene.control.ToggleButton;

public class ViewUtil {


    /**
     * Creates a ToggleButton with custom text and custom Styling
     * this is just a code reuse method
     * @param text
     * @return
     */
    static ToggleButton getRoundButton(String text) {
        ToggleButton button = new ToggleButton(text);
        button.setStyle(
                "-fx-background-color: lightblue;" +
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 100px; " +
                        "-fx-max-width: 100px; " +
                        "-fx-max-height: 100px;"
        );


        button.setOnAction(actionEvent -> {
            if(button.isSelected()){
                button.setStyle(
                        "-fx-background-color: cornflowerblue;" +
                                "-fx-background-radius: 5em; " +
                                "-fx-min-width: 100px; " +
                                "-fx-min-height: 100px; " +
                                "-fx-max-width: 100px; " +
                                "-fx-max-height: 100px;"
                );
            }
            else {
                button.setStyle(
                        "-fx-background-color: lightblue;" +
                                "-fx-background-radius: 5em; " +
                                "-fx-min-width: 100px; " +
                                "-fx-min-height: 100px; " +
                                "-fx-max-width: 100px; " +
                                "-fx-max-height: 100px;"
                );
            }
        });
        return button;
    }

}
