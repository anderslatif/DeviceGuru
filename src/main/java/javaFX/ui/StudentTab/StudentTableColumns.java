package javaFX.ui.StudentTab;

import javaFX.models.Device.DeviceService;
import javaFX.models.DeviceLogin.DeviceLoginService;
import javaFX.models.Student.Student;
import javaFX.models.Student.StudentService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class StudentTableColumns {


    public static void setUpColumns(TableView<Student> studentTable, StudentService studentService,
                             DeviceService deviceService, DeviceLoginService deviceLoginService) {
        //creating firstNamecolumn
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("Fornavn");
        firstNameColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.15));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        firstNameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setFirstName(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });


        //creating lastnamecolumn
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("Efternavn");
        lastNameColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.15));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        lastNameColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setLastName(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });


        //creating schoolclasscolumn
        TableColumn<Student, String> classColumn = new TableColumn<>("Klasse");
        classColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.05));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("schoolClass"));
        classColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        classColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setSchoolClass(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });

        //creating emailcolumn
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
        emailColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.17));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        emailColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).setEmail(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            studentService.save(student);
        });

        //creating devicecolumn
        TableColumn<Student, String> deviceColumn = new TableColumn<>("Device");
        deviceColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.16));
        deviceColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDevice().getType());
            }
        });
        deviceColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        deviceColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getDevice().setType(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            deviceService.save(student.getDevice());
        });

        //creating serialnumbercolumn
        TableColumn<Student, String> serialnumberColumn = new TableColumn<>("Serienummer");
        serialnumberColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.16));
        serialnumberColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDevice().getSerialnumber());
            }
        });
        serialnumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        serialnumberColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getDevice().setSerialnumber(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            deviceService.save(student.getDevice());
        });

        //creating adgangskode column
        TableColumn<Student, String> passwordColumn = new TableColumn<>("Adgangskode");
        passwordColumn.maxWidthProperty().bind(studentTable.widthProperty().multiply(0.16));
        passwordColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> data) {
                return new SimpleStringProperty(data.getValue().getDeviceLogin().getPassword());
            }
        });
        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        passwordColumn.setOnEditCommit( (TableColumn.CellEditEvent<Student, String> t) -> {
            (t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
            ).getDeviceLogin().setPassword(t.getNewValue());
            Student student = studentTable.getSelectionModel().getSelectedItem();
            deviceLoginService.save(student.getDeviceLogin());
        });


        //adding columns
        studentTable.getColumns().addAll(firstNameColumn, lastNameColumn, classColumn, emailColumn, deviceColumn, serialnumberColumn, passwordColumn);

    }


}
