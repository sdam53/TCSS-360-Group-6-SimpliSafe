package view;

import com.sun.source.tree.Tree;
import controller.Controller;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.*;

import java.util.ArrayList;

/**
 * This class is for the Device Tab and this displays all the Devices using the
 * TreeTableView
 */
public class DeviceScene {
    /**
     * pane getter
     * @return pane
     */
    public Pane getPane() {
        return this.pane;
    }

    //instance field for the pane
    BorderPane pane = new BorderPane();

    //This list is used for dynamic entry of devices since the name
    //of each elemnent in the List is not needed and is used in parallel
    //with the Component Ordinal array
    static ArrayList<TreeItem> treeTabs = new ArrayList<>();

    static ArrayList<TreeItem> treeTabsBasis = new ArrayList<>();

    //The basis of the TreeTableView
    static TreeTableView<Device> deviceList = new TreeTableView<>();

    /**
     * constructor that also serves as the initilization function for
     * the TreeTableView
     */
    public DeviceScene() {

        //The Five columns below correspond to the 5 columns in the the TreeTableView
        //They do three things the first is instantiate a TreeTableColumn<Device, String>
        //which also gives the title of the column

        //The Second thing is that each column has their CellValueFactory set to a new
        //TreeItemPropertyValueFactory where each column is associated with one of the 5
        //fields of the device class

        //The third thing is to set the Preferred width of each of the columns]
        //The values are arbitrary and were determined through trial and error

        TreeTableColumn<Device, String> column1 = new TreeTableColumn<>("Name");
        column1.setCellValueFactory(new TreeItemPropertyValueFactory<>("myName"));
        column1.setPrefWidth(400);

        TreeTableColumn<Device, String> column2 = new TreeTableColumn<>("ID");
        column2.setCellValueFactory(new TreeItemPropertyValueFactory<>("myID"));
        column2.setPrefWidth(100);

        TreeTableColumn<Device, String> column3 = new TreeTableColumn<>("Status");
        column3.setCellValueFactory(new TreeItemPropertyValueFactory<>("myStatus"));
        column3.setPrefWidth(100);

        TreeTableColumn<Device, String> column4 = new TreeTableColumn<>("Battery");
        column4.setCellValueFactory(new TreeItemPropertyValueFactory<>("myBattery"));
        column4.setPrefWidth(100);

        //adds the columns to the TreeTableView
        deviceList.getColumns().addAll(column1, column2, column3, column4);

        update();

        //sets the deviceList as the center of the pane for display
        this.pane.setCenter(deviceList);

    }

    /**
     * updates the DeviceScene GUI when new devices are added or alarmed
     */
    public static void update() {
        TreeItem newDevices = new TreeItem(new BlankDevice("Devices"));
        treeTabs = new ArrayList<>();

        for (Component c : Component.values()) {

            treeTabs.add(new TreeItem((new BlankDevice(c.toString()))));

        }
        for (TreeItem t: treeTabs) {
            newDevices.getChildren().add(t);
        }

        for (Device d:
                Controller.getSensors()) {
            addDevice(d);
        }

        for (Device d:
                Controller.getAlarms()) {
            addDevice(d);
        }

        deviceList.setRoot(newDevices);
    }

    /**
     * This takes an object of Type Device (or one of it's children) and depending on what
     * kind of Device it is it gets added to the appropriate node in TreeTabs
     * @param d the device
     */
    public static void addDevice(Device d) {
        treeTabs.get(d.getMyType().ordinal()).getChildren().add(new TreeItem<>(d));
    }

    /**
     * This takes the two String inputs that are used in the Device Constructor and
     * serves as a shortcut for interacting with the GUI
     * @param name the name of the device
     * @param alias the type of device
     */
    public static void addDevice(String name, String alias) {
        switch (Component.deriveKind(alias)) {
            case "sensor" -> {
                addDevice(new Sensor(name, alias));
                break;
            }
            case "alarm" -> {
                addDevice(new Alarm(name, alias));
                break;
            }
            default -> {
                break;
            }

        }

    }



}




