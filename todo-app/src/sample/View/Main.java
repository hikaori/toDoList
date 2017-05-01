package sample.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Pagination;
import javafx.util.Callback;

import java.awt.*;

public class Main extends Application
{
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Initialize stage
        stage = primaryStage;
        primaryStage.setTitle("Login");

        // Show create your account screen
        Scene scene = createAccountScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /***************************************************************************
    Screen mame: Create new account
    Description: Get createNewAccount scene
     ***************************************************************************/
    public Scene createAccountScene()
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btn = new Button("Create account");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(javafx.scene.paint.Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
                stage.setTitle("Index");
                stage.setScene(loginScene());
            }
        });

        Text scenetitle = new Text("Welcome! \nCreate an account");
        scenetitle.setFont(javafx.scene.text.Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);


        Hyperlink hyperlink = new Hyperlink("create your acount");

        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getHostServices().showDocument("https://eclipse.org");
            }
        });

        grid.getChildren().addAll(hyperlink);
        hyperlink.setPadding(new Insets(100, 0, 20, 0));

        Scene scene = new Scene(grid, 300, 275);
        return scene;
    }

    /***************************************************************************
     Screen mame: Index
     Description: Get Index scene
     ***************************************************************************/
    public Scene indexScene()
    {
        // Make grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // TextField
        TextField todoInputField = new TextField();
        grid.add(todoInputField, 0, 0);

        // Button
        Button btn = new Button("Add");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 0);

        // Paging view
        Pagination pagination = new Pagination(5, 0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(pageIndex);
            }
        });
        grid.add(pagination, 0, 1, 2, 1);

        Scene scene = new Scene(grid, 400, 400);

        return scene;
    }

    public VBox createPage(int pageIndex)
    {
        VBox box = new VBox(5);
        int page = pageIndex * itemsPerPage();
        for (int i = page; i < page + itemsPerPage(); i++)
        {
            // Make grid
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(10, 0, 10, 5));

            // Add test and button
            Label text = new Label("Test" + (i+1));
//            text.setStyle("-fx-background-color: #FFFFFF;");
            Button btn = new Button();
            btn.setText("Delete");
            btn.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Delete button tapped");
                }
            });
            grid.add(text, 0, 0);
            grid.add(btn, 1, 0);
            VBox element = new VBox(grid);
            box.getChildren().add(element);
        }
        return box;
    }

    public int itemsPerPage() {
        return 5;
    }

    /***************************************************************************
     Screen mame: Login
     Description: Get Login scene
     ***************************************************************************/
    public Scene loginScene()
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
            public void handle(ActionEvent e)
            {
                stage.setTitle("Index");
                stage.setScene(indexScene());
                actiontarget.setText("Sign in button pressed");
            }
        });

        Scene scene = new Scene(grid, 300, 275);

        return scene;
    }
//    public Scene logoutScene() {}

    public static void main(String[] args)
    {
        launch(args);
    }
}
