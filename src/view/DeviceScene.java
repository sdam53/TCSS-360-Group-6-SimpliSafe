package view;

import com.sun.source.tree.Tree;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Alarm;
import model.Component;
import model.Device;
import model.Sensor;

import java.util.ArrayList;

public class DeviceScene {
    public Pane getPane() {
        return this.pane;
    }

    BorderPane pane = new BorderPane();
    static ArrayList<TreeItem> treeTabs = new ArrayList<>();
    static TreeTableView<Device> deviceList = new TreeTableView<>();
    public DeviceScene() {





        TreeTableColumn<Device, String> column1 = new TreeTableColumn<>("Name");
        column1.setCellValueFactory(new TreeItemPropertyValueFactory<>("myName"));

        TreeTableColumn<Device, String> column2 = new TreeTableColumn<>("ID");
        column2.setCellValueFactory(new TreeItemPropertyValueFactory<>("myID"));

        TreeTableColumn<Device, String> column3 = new TreeTableColumn<>("Status");
        column3.setCellValueFactory(new TreeItemPropertyValueFactory<>("myStatus"));

        TreeTableColumn<Device, String> column4 = new TreeTableColumn<>("Type");
        column4.setCellValueFactory(new TreeItemPropertyValueFactory<>("myType"));

        TreeTableColumn<Device, String> column5 = new TreeTableColumn<>("Battery");
        column5.setCellValueFactory(new TreeItemPropertyValueFactory<>("myBattery"));

        deviceList.getColumns().addAll(column1, column2, column3, column4, column5);

        TreeItem devices = new TreeItem(new Alarm("Devices", "..."));


        for (Component c : Component.values()) {

            switch (c.getKind()) {
                case "sensor" -> {
                    treeTabs.add(new TreeItem(new Sensor(c.toString() + "'s", c.toString())));
                    break;
                }
                case "alarm" -> {
                    treeTabs.add(new TreeItem(new Alarm(c.toString() + "'s", c.toString())));
                    break;
                }
                default -> {
                    break;
                }

            }

        }

        for (TreeItem t: treeTabs) {
            devices.getChildren().add(t);
        }

        addDevice(new Sensor("Entry Sensor Main Door", "ENTRYSENSOR"));




        deviceList.setRoot(devices);

        this.pane.setCenter(deviceList);

    }

    public static void addDevice(Device d) {
        treeTabs.get(d.getMyType().ordinal()).getChildren().add(new TreeItem<>(d));
    }

    public static void addDevice(String name, String alias) {
        switch (alias) {
            case "sensor" -> {
                treeTabs.get(Component.getType(alias).ordinal()).getChildren().add(new TreeItem<>(new Sensor(name, alias)));
                break;
            }
            case "alarm" -> {
                treeTabs.get(Component.getType(alias).ordinal()).getChildren().add(new TreeItem<>(new Alarm(name, alias)));
                break;
            }
            default -> {
                break;
            }

        }

    }

}




