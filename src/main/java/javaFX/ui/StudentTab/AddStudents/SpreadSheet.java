package javaFX.ui.StudentTab.AddStudents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;

public class SpreadSheet {



    public static SpreadsheetView returnSpreadSheet() {

        int rowCount = 100;
        int columnCount = 15;
        GridBase grid = new GridBase(rowCount, columnCount);

        ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();
        for (int row = 0; row < grid.getRowCount(); ++row) {
            final ObservableList<SpreadsheetCell> list = FXCollections.observableArrayList();
            for (int column = 0; column < grid.getColumnCount(); ++column) {
                if (row == 0) {
                    SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"");
                    cell.setStyle("-fx-background-color: #04B404");
                    list.add(cell);
                } else {
                    list.add(SpreadsheetCellType.STRING.createCell(row, column, 1, 1,""));
                }
            }
            rows.add(list);
        }
        grid.setRows(rows);

        SpreadsheetView spreadsheetView = new SpreadsheetView(grid);

        return spreadsheetView;
    }

    private SpreadsheetCell stringCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"");
        return cell;
    }

    private SpreadsheetCell firstRowCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.STRING.createCell(row, column, 1, 1,"");
        cell.setStyle("-fx-background-color: green");
        return cell;
    }

    private SpreadsheetCell intCell(int row, int column) {
        SpreadsheetCell cell = SpreadsheetCellType.INTEGER.createCell(row, column, 1, 1, null);
        return cell;
    }



}
