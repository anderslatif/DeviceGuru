package javaFX.ui.StudentTab.AddStudents;

import javaFX.App;
import javaFX.ui.StudentTab.StudentTabView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddStudentsController {

    @Autowired
    StudentTabView studentTabView;

    @FXML
    BorderPane mainCreateStudentsBorderPane;

    @FXML
    Button readToDBButton;

    @FXML
    Button returnButton;

    @FXML
    Button helpButton;

    GlyphFont fontAwesome;




    @FXML
    public void initialize() {
        fontAwesome = GlyphFontRegistry.font("FontAwesome");

        readToDBButton.setOnAction( e -> readToDB());
        returnButton.setOnAction( e -> returnToMainNode());

        addSpreadSheet();
        setUpHelpButton();
    }

    private void setUpHelpButton() {
        Glyph glyph = fontAwesome.create(FontAwesome.Glyph.QUESTION_CIRCLE)/*.size(28).color(Color.RED)*/;
        helpButton.getStyleClass().add("glyph_button");
        helpButton.setGraphic(glyph);
        helpButton.setOnAction( e -> informationGuide());
    }

    private void informationGuide() {
        TextArea textArea = new TextArea();
        textArea.setText("This explains how it works");
        mainCreateStudentsBorderPane.setBottom(textArea);
        helpButton.setGraphic(null);
        helpButton.setText("Spreadsheet");
        helpButton.setOnAction( e -> addSpreadSheet());

        for (ObservableList<SpreadsheetCell> c : SpreadSheet.getRows()) {
            System.out.println(c);
        }



    }

    private void addSpreadSheet() {
        mainCreateStudentsBorderPane.setBottom(SpreadSheet.returnSpreadSheet());
        Glyph glyph = fontAwesome.create(FontAwesome.Glyph.QUESTION_CIRCLE)/*.size(28).color(Color.RED)*/;
        helpButton.getStyleClass().add("glyph_button");
        helpButton.setGraphic(glyph);
        helpButton.setText("");
        helpButton.setOnAction( e -> informationGuide());
    }

    private void readToDB() {
        // check if columns more than one and allowed
    }


    private void errorMessageTextArea(String errorMessage) {
        TextArea textArea = new TextArea(errorMessage);
        mainCreateStudentsBorderPane.setBottom(textArea);
    }

    private void returnToMainNode() {

        mainCreateStudentsBorderPane.setBottom(null);

        TabPane tabPane = (TabPane) App.getStage().getScene().getRoot().lookup("#tabPane");
        int selectedTabIndex = tabPane.getSelectionModel().getSelectedIndex();
        Tab selectedTab = tabPane.getTabs().get(selectedTabIndex);

        selectedTab.setContent(studentTabView.getView());
    }


}
