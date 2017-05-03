package sample.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
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
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Pagination;
import javafx.util.Callback;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        primaryStage.setScene(loginScene());
        primaryStage.show();

    }

    /***************************************************************************
    Screen name: Create new account
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
     Screen name: Index
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


        // Button
        Button btnLogout = new Button("Logout");
        HBox hBtn = new HBox(10);
        btnLogout.setAlignment(Pos.BOTTOM_RIGHT);
        hBtn.getChildren().add(btnLogout);
        btnLogout.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) {

                // Go to logout scene
                stage.setTitle("Logout");
                stage.setScene(logoutScene());
            }
        });
        grid.add(btnLogout, 1, 2);

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
     Screen name: Login
     Description: Get Login scene
     memo: momo changed 5/2
     ***************************************************************************/
        public Scene loginScene()
    {
        stage.setTitle("To do list_login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btnNew = new Button("New account");
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnNew);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1,4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e)
            {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");

                // Go to index scene
                stage.setTitle("Index");
                stage.setScene(indexScene());
            }
        });

        btnNew.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e)
            {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Create account button pressed");

                // Go to create account scene
                stage.setTitle("New account");
                stage.setScene(createAccountScene());
            }
        });

        Text scenetitle = new Text("To Do List");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);


        Scene scene = new Scene(grid, 350, 280);
        return scene;
    }

    /***************************************************************************
     Screen mame: Logout
     Description: Get Logout scene
     ***************************************************************************/
    public Scene logoutScene()
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //UNLOCKED ICON IMAGE
        // 単純に画像を読み込んで表示。ファイルの場合はnew File( "ファイル名" ).toURI().toString()でパスを指定する
        Image img = new Image("http://icons.iconarchive.com/icons/iconsmind/outline/128/Unlock-icon.png");
        ImageView imgView = new ImageView(img);

        grid.addRow(0, imgView);
        GridPane.setHalignment(imgView, HPos.CENTER);

        //TEXT
        final Text actionTarget = new Text("Are you sure to logout your account?");
        grid.add(actionTarget, 0, 1);

        //BUTTON
        Button btnNew = new Button("Cancel");
        Button btn = new Button("OK");
        HBox hbBtn2 = new HBox(5);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add(btnNew);
        hbBtn2.getChildren().add(btn);
        grid.add(hbBtn2, 0,2);

        Scene scene = new Scene(grid, 350, 280);
        return scene;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
