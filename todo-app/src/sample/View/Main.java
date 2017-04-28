package sample.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;

public class Main extends Application
{
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage = primaryStage;
        primaryStage.setTitle("Login");

        // Login
        Scene scene = logInScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene logInScene()
    {
        Pane root = new Pane();

        // Make grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Text
        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        // Label
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        // TextField
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        // Label
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        // PasswordField
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        // Button
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        // Text
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setId("actiontarget");

        // Add action
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setText("Sign in button pressed");
            }
        });

        Scene scene = new Scene(grid, 300, 275);

        return scene;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
