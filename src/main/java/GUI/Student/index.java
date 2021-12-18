package GUI.Student;

import Database.Database;
import Domain.Cursist;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class index {


    public Scene getVıew() {
        Database database = new Database();
        Parent layouts = database.getViewCursist();

        Scene scene = new Scene(layouts);

        return scene;
    }

}

