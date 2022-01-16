/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//Switch scene na index class

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author quinc
 */
public class MainMenu extends Application {
    private StudentMenu studentMenu = new StudentMenu();
    private CourseMenu courseMenu = new CourseMenu();
    private EnrollMenu enrollMenu = new EnrollMenu();
    private CompletedCourseOverview  ccOverview = new CompletedCourseOverview();
    private EarnedCertificateOverview ecOverview = new EarnedCertificateOverview();
    private TopThreeWebcastOverview wcOverview = new TopThreeWebcastOverview();
    private AmmountPassedCourseView apcOverview = new AmmountPassedCourseView();
    private ModuleProgressionOverview mcOverview = new ModuleProgressionOverview();

    private Label crudLabel = new Label("CRUD");
    private Label progressLabel = new Label("Voortgang invoeren");
    private Label viewLabel = new Label("Overzichten");
    private Button cursistBtn = new Button("Cursisten");
    private Button cursusBtn = new Button("Course");
    private Button enrollBtn = new Button("Inschrijven");
    private Button webcastBtn = new Button("Webcast");
    private Button moduleBtn = new Button("Module");
    private Button view1 = new Button("Behaalde\ncertificaten\nper gender");
    private Button view2 = new Button("view2");
    private Button view3 = new Button("Module \n progression");
    private Button view4 = new Button("Behaalde\ncertificaten\nvan acccount");
    private Button view5 = new Button("Top\ndrie webcast");
    private Button view8 = new Button("Hoe vaak is\neen cursus\nbehaald");





    @Override
    public void start(Stage window) {
        window.setTitle("Quincy van Deursen (2113709), Batin Simsek (2185026), Thomas van Otterloo (2186082)");
        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-background-color: #52819D;");
        layout.setPrefSize(600,700);
        layout.setPadding(new Insets(40 ,40 ,40 ,40));

        //button en label styling
        this.cursusBtn.setPadding(new Insets( 30,30,30,30));
        this.cursistBtn.setPadding(new Insets( 30,30,30,30));
        this.enrollBtn.setPadding(new Insets( 30,30,30,30));
        this.webcastBtn.setPadding(new Insets( 30,30,30,30));
        this.moduleBtn.setPadding(new Insets( 30,30,30,30));
        this.view1.setPadding(new Insets( 20,20,20,20));
        this.view2.setPadding(new Insets( 30,30,30,30));
        this.view3.setPadding(new Insets( 20,20,20,20));
        this.view4.setPadding(new Insets( 20,20,20,20));
        this.view5.setPadding(new Insets( 20,20,20,20));
        this.view8.setPadding(new Insets( 20,20,20,20));


        this.cursusBtn.setFont(Font.font ("Verdana", 15));
        this.cursistBtn.setFont(Font.font ("Verdana", 15));
        this.enrollBtn.setFont(Font.font ("Verdana", 15));
        this.webcastBtn.setFont(Font.font ("Verdana", 15));
        this.moduleBtn.setFont(Font.font ("Verdana", 15));
        this.view1.setFont(Font.font ("Verdana", 10));
        this.view2.setFont(Font.font ("Verdana", 15));
        this.view3.setFont(Font.font ("Verdana", 10));
        this.view4.setFont(Font.font ("Verdana", 10));
        this.view5.setFont(Font.font ("Verdana", 10));
        this.view8.setFont(Font.font ("Verdana", 10));

        this.progressLabel.setFont(Font.font ("Verdana", 20));
        this.crudLabel.setFont(Font.font ("Verdana", 20));
        this.viewLabel.setFont(Font.font ("Verdana", 20));


        //crud menu
        HBox crudMenu = new HBox();
        crudMenu.setPadding(new Insets(10));
        crudMenu.setSpacing(25);
        crudMenu.getChildren().addAll(cursistBtn, enrollBtn, cursusBtn);
        crudMenu.setAlignment(Pos.CENTER);

        VBox crudMenu2 = new VBox();
        crudMenu2.setAlignment(Pos.CENTER);
        crudMenu2.getChildren().addAll(this.crudLabel, crudMenu);


        cursistBtn.setOnAction((event) -> window.setScene(studentMenu.getView()));
        cursusBtn.setOnAction((event) -> window.setScene(courseMenu.getView()));
        enrollBtn.setOnAction(actionEvent -> window.setScene(enrollMenu.getScene()));

        //progressie menu
        HBox progressMenu = new HBox();
        progressMenu.setSpacing(25);
        progressMenu.getChildren().addAll(this.webcastBtn,this.moduleBtn);
        progressMenu.setAlignment(Pos.TOP_CENTER);

        VBox progressMenu2 = new VBox();
        progressMenu2.getChildren().addAll(this.progressLabel,progressMenu );
        progressMenu2.setAlignment(Pos.CENTER);

        //this.webcastBtn.setOnAction((event) -> window.setScene( xxxxxxxxxxx .getView()));
        //this.moduleBtn.setOnAction(actionEvent -> window.setScene(xxxxxxxxxxxxx .getScene()));

        //view menu
        HBox viewMenu1 = new HBox();
        viewMenu1.setPadding(new Insets(10));
        viewMenu1.setSpacing(25);
        viewMenu1.getChildren().addAll(this.view1,this.view2, this.view3);
        viewMenu1.setAlignment(Pos.CENTER);

        HBox viewMenu2 = new HBox();
        viewMenu2.setPadding(new Insets(10));
        viewMenu2.setSpacing(25);
        viewMenu2.getChildren().addAll(this.view4,this.view5, view8);
        viewMenu2.setAlignment(Pos.CENTER);

        VBox viewMenu3 = new VBox();
        viewMenu3.getChildren().addAll(this.viewLabel, viewMenu1, viewMenu2 );
        viewMenu3.setAlignment(Pos.CENTER);

        this.view1.setOnAction((event) -> window.setScene(ccOverview.getView()));
        //this.view2.setOnAction(actionEvent -> window.setScene(xx.getView()));
        this.view3.setOnAction((event) -> window.setScene( mcOverview.getView()));
        this.view4.setOnAction(actionEvent -> window.setScene(ecOverview.getView()));
        this.view5.setOnAction((event) -> window.setScene( wcOverview.getView()));
        this.view8.setOnAction(actionEvent -> window.setScene(apcOverview.getView()));

        //scene layout
        layout.setTop(crudMenu2);
        layout.setCenter(progressMenu2);
        layout.setBottom(viewMenu3);

        Scene scene = new Scene(layout);
        this.progressLabel.setPadding(new Insets(25));

//        Buttons die terug naar main menu gaan (public en zijn aanwezig in de andere views).
        enrollMenu.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        studentMenu.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        ccOverview.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        ecOverview.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        wcOverview.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        apcOverview.backBtn.setOnAction(actionEvent -> window.setScene(scene));
        mcOverview.backBtn.setOnAction(actionEvent -> window.setScene(scene));

        window.setScene(scene);
        window.show();
    }
}
