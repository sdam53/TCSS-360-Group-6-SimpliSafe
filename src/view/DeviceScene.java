package view;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DeviceScene {
    public Pane getPane() {
        return this.pane;
    }

    BorderPane pane = new BorderPane();
    TreeTableView<Device> deviceList = new TreeTableView<>();
    public DeviceScene() {



        TreeTableColumn<Device, String> column1 = new TreeTableColumn<>("Device");
        column1.setCellValueFactory(new TreeItemPropertyValueFactory<>("device"));

        TreeTableColumn<Device, String> column2 = new TreeTableColumn<>("ID");
        column2.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));

        deviceList.getColumns().addAll(column1, column2);

        TreeItem sensor1 = new TreeItem(new Device("Entry Sensor", "1"));
        TreeItem sensor2 = new TreeItem(new Device("Entry Sensor", "2"));
        TreeItem sensor3 = new TreeItem(new Device("Entry Sensor", "3"));
        TreeItem sensors = new TreeItem(new Device("Sensor", "..."));
        sensors.getChildren().addAll(sensor1, sensor2, sensor3);

        TreeItem alarm1 = new TreeItem(new Device("Entry Alarm", "4"));
        TreeItem alarm2 = new TreeItem(new Device("Entry Alarm", "5"));
        TreeItem alarm3 = new TreeItem(new Device("Smoke ALarm", "6"));
        TreeItem alarms = new TreeItem(new Device("Alarms", "..."));
        alarms.getChildren().addAll(alarm1, alarm2, alarm3);

        TreeItem devices = new TreeItem(new Device("Devices", "..."));
        devices.getChildren().addAll(sensors, alarms);

        deviceList.setRoot(devices);

        this.pane.setCenter(deviceList);

    }

    public class Device {
        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        private String device = null;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        private String status = null;

        public Device() { }

        public Device(String device, String status) {
            this.device = device;
            this.status = status;
        }
    }
}




