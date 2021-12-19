/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//Switch scene na index class
import GUI.Student.Index;

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
public class Main extends Application {
    private Index student = new Index();

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(600,600);
        HBox menu = new HBox();
        layout.setTop(menu);
        menu.setPadding(new Insets(10));
        menu.setSpacing(25);




        Button studentBtn = new Button("Studenten");
        Button courseBtn = new Button("Course");
        Button moduleBtn = new Button("Module");
        Button webcastBtn = new Button("Webcast");
        menu.getChildren().addAll(studentBtn, courseBtn, moduleBtn, webcastBtn);


        studentBtn.setOnAction((event) -> window.setScene(student.getVıew()));


        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
//       database database = new database();
//       database.showCursisten();
        launch(Main.class);
    }
}
