package view;

import com.sun.source.tree.Tree;
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
     * @return
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

        TreeTableColumn<Device, String> column4 = new TreeTableColumn<>("Type");
        column4.setCellValueFactory(new TreeItemPropertyValueFactory<>("myType"));
        column4.setPrefWidth(150);

        TreeTableColumn<Device, String> column5 = new TreeTableColumn<>("Battery");
        column5.setCellValueFactory(new TreeItemPropertyValueFactory<>("myBattery"));
        column5.setPrefWidth(45);

        //adds the columns to the TreeTableView
        deviceList.getColumns().addAll(column1, column2, column3, column4, column5);

        //creating the root Node
        TreeItem devices = new TreeItem(new BlankDevice("Devices"));


        //initilizaing the treeTabs by creating a treeItem of a device
        //for each Component enum in parallel with the ordinal array
        // (I think that's what it's called whatever the array
        // the enums are stored in)
        for (Component c : Component.values()) {

            //determines which constructor is needed and makes sure to use the one parameter
            //constructor to get null information
            treeTabs.add(new TreeItem((new BlankDevice(c.toString()))));
            /*
            switch (c.getKind()) {
                case "sensor" -> {
                    treeTabs.add(new TreeItem(new Sensor(c.toString())));
                    break;
                }
                case "alarm" -> {
                    treeTabs.add(new TreeItem(new Alarm(c.toString())));
                    break;
                }
                default -> {
                    break;
                }

            }
            */
        }

        //adds all the TreeItems in treeTabs to the rootNode
        for (TreeItem t: treeTabs) {
            devices.getChildren().add(t);
        }


        //sets the root node as the root for deviceList
        deviceList.setRoot(devices);

        //sets the deviceList as the center of the pane for display
        this.pane.setCenter(deviceList);

    }

    /**
     * This takes an object of Type Device (or one of it's children) and depending on what
     * kind of Device it is it gets added to the appropriate node in TreeTabs
     * @param d
     */
    public static void addDevice(Device d) {
        treeTabs.get(d.getMyType().ordinal()).getChildren().add(new TreeItem<>(d));
    }

    /**
     * This takes the two String inputs that are used in the Device Constructor and
     * serves as a shortcut for interacting with the GUI
     * @param name
     * @param alias
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




