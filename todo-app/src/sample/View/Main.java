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
import javafx.scene.text.Text;
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

        // Show login screen
        Scene scene = loginScene();
        primaryStage.setScene(scene);
        primaryStage.show();
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
                stage.setScene(indexScene());
                stage.setTitle("Index");
                actiontarget.setText("Sign in button pressed");
            }
        });

        Scene scene = new Scene(grid, 300, 275);

        return scene;
    }

//    public Scene createAccountScene() {}
//    public Scene logoutScene() {}

    public static void main(String[] args)
    {
        launch(args);
    }
}
