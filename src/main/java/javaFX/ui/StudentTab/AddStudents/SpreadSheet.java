package javaFX.ui.StudentTab.AddStudents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import org.controlsfx.control.spreadsheet.*;

public class SpreadSheet {


    static ObservableList<ObservableList<SpreadsheetCell>> rows;

    public static SpreadsheetView returnSpreadSheet() {

        int rowCount = 80;
        int columnCount = 10;
        GridBase grid = new GridBase(rowCount, columnCount);

        rows = FXCollections.observableArrayList();


//        ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();
        for (int row = 0; row < grid.getRowCount(); ++row) {
            final ObservableList<SpreadsheetCell> list = FXCollections.observableArrayList();
            for (int column = 0; column < grid.getColumnCount(); ++column) {
                if (row == 0) {
                    list.add(firstRowCell(row, column));
                } else {
                    list.add(stringCell(row, column));
                }
            }
            rows.add(list);
        }
        grid.setRows(rows);

        SpreadsheetView spreadsheetView = new SpreadsheetView(grid);

        return spreadsheetView;
    }

    public static SpreadsheetCell firstRowCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"             ");
        cell.setStyle("-fx-background-color: #04B404");

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


}
