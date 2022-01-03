/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//Switch scene na index class

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author quinc
 */
public class HoofdMenu extends Application {
    private StudentMenu cMenu = new StudentMenu();
    private CourseMenu courseMenu = new CourseMenu();
    private InschrijfMenu inschrijfMenu = new InschrijfMenu();

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(600,600);
        HBox menu = new HBox();
        layout.setTop(menu);
        menu.setPadding(new Insets(10));
        menu.setSpacing(25);

        Button CursistBtn = new Button("Cursisten");
        Button cursusBtn = new Button("Course");
        Button moduleBtn = new Button("Module");
        Button webcastBtn = new Button("Webcast");
        Button inschrijfBtn = new Button("Inschrijven");
        menu.getChildren().addAll(CursistBtn, inschrijfBtn, cursusBtn, moduleBtn, webcastBtn);

        CursistBtn.setOnAction((event) -> window.setScene(cMenu.getView()));
        cursusBtn.setOnAction((event) -> window.setScene(courseMenu.getView()));
        inschrijfBtn.setOnAction(actionEvent -> window.setScene(inschrijfMenu.getScene()));


        Scene scene = new Scene(layout);

//        Buttons die terug naar main menu gaan.
        inschrijfMenu.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        cMenu.backBtn.setOnAction(actionEvent -> window.setScene(scene));

        window.setScene(scene);
        window.show();
    }
}
