package javaFX.util;

import javaFX.App;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class UserMessage {

    public static void showSuccess(String text) {
        Label label = new Label(text);
        label.setTextFill(Color.GREEN);
        createUserMessage(label);
    }

    public static void showFailure(String text) {
        Label label = new Label(text);
        label.setTextFill(Color.RED);
        createUserMessage(label);
    }

    public static void createUserMessage(Label label) {
        BorderPane borderPane = (BorderPane) App.getStage().getScene().getRoot().lookup("#mainWindowBorderPane");
        borderPane.setBottom(label);


        label.setStyle( "-fx-border-color:black; -fx-font-size: 16;" );
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPrefHeight(150.00);
        label.setAlignment(Pos.TOP_CENTER);
        label.getStyleClass().add("bottomLabel");

        borderPane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                borderPane.setBottom(null);
            }
        });
    }


}
