package javaFX.ui.StudentTab.AddStudents;

import javaFX.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TablePosition;
import javafx.scene.input.*;
import org.controlsfx.control.spreadsheet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SpreadSheet {

    static ObservableList<ObservableList<SpreadsheetCell>> rows;

    // how to paste on cell select (includes multi cell pasting)
    // https://groups.google.com/forum/#!topic/controlsfx-dev/wxuqDwCpGgY

    private static SpreadsheetView spreadsheetView;

    public static SpreadsheetView returnSpreadSheet() {

        if (spreadsheetView != null) {
            return spreadsheetView;
        }

        int rowCount = 100;
        int columnCount = 15;
        GridBase grid = new GridBase(rowCount, columnCount);
        rows = FXCollections.observableArrayList();


        for (int row = 0; row < grid.getRowCount(); ++row) {
            final ObservableList<SpreadsheetCell> list = FXCollections.observableArrayList();
            for (int column = 0; column < grid.getColumnCount(); ++column) {
                if (row == 0) {
                    List<String> studentVariables = Arrays.asList("...                 ", "Fornavn", "Efternavn", "Klasse", "Email", "Device", "Serienummer", "Adgangskode", "Indskolingen", "Udskolingen", "Indmeldt", "Gradueret");
                    SpreadsheetCell cell = firstRowCell(row, column);
                    cell = SpreadsheetCellType.LIST(studentVariables).createCell(row, column, 1, 1, null);
                    cell.setStyle("-fx-background-color: #04B404");
                    list.add(cell);
                } else {
                    list.add(stringCell(row, column));
                }
            }
            rows.add(list);
        }
        grid.setRows(rows);

        spreadsheetView = new SpreadsheetView(grid);
        spreadsheetView.setId("spreadsheetView");
//        spreadsheetView.prefWidthProperty().bind(App.getStage().widthProperty().subtract(50));
//        spreadsheetView.prefHeightProperty().bind(App.getStage().heightProperty().subtract(100));

        spreadsheetView.setFixingColumnsAllowed(true);

        setupPastingInSpreadsheet();

        return spreadsheetView;
    }

    public static SpreadsheetCell firstRowCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"             ");
        cell.setStyle("-fx-background-color: #04B404");
 //       final ChoiceBox<String> choiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Normal", "Both"));

        return cell;
    }

    private static SpreadsheetCell stringCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"");
        return cell;
    }

    private static SpreadsheetCell intCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.INTEGER.createCell(row, column, 1, 1, null);
        return cell;
    }

    public static ObservableList<ObservableList<SpreadsheetCell>> getRows() {
        return rows;
    }

    public static void setupPastingInSpreadsheet() {

        Scene scene = App.getStage().getScene();
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY), new Runnable() {

            Clipboard clipboard = Clipboard.getSystemClipboard();
            DataFormat dataFormat = getDataFormat(clipboard.getContentTypes());
            @Override
            public void run() {
                pasteIntoSpreadsheet(clipboard, dataFormat);
            }
        });
    }

    private static DataFormat getDataFormat(Set<DataFormat> formats) {
        for (DataFormat format : formats) {
            return format;
        }
        return null;
    }


    public static void pasteIntoSpreadsheet(Clipboard clipboard, DataFormat dataFormat) {

        final TablePosition<?, ?> focusedCell = spreadsheetView.getSelectionModel().getFocusedCell();

        int currentRow = focusedCell.getRow();

        final int baseColumn = focusedCell.getColumn();
        int currentColumn = focusedCell.getColumn();

        if (currentRow == -1 || currentColumn == -1) {
            return;
        }


        @SuppressWarnings("unchecked")
        final ArrayList<GridChange> list = (ArrayList<GridChange>) clipboard.getContent(dataFormat);

    }

}
