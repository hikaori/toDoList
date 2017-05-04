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
import sample.Model.Database;
import sample.Model.User;

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
     memo: momo changed May 3rd
     ***************************************************************************/
    public Scene createAccountScene()
    {
        // Set margin / space
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Create account button
        Button btn = new Button("Make an account");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Made your account");
            }
        });

        // Message
        Text scenetitle = new Text("Put your name & password");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // User name
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        // Password
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);


        return new Scene(grid, 300, 275);
    }

    /***************************************************************************
     Screen name: Index
     Description: Get Index scene
     ***************************************************************************/
    public Scene indexScene()
    {
        // Set margin / space
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // ToDo input field
        TextField todoInputField = new TextField();
        grid.add(todoInputField, 0, 0);

        // Add button
        Button btnAdd = new Button("Add");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnAdd);
        grid.add(hbBtn, 1, 0);
        btnAdd.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) {

                // TODO: Add todo -> reload todo contents
                System.out.println("ToDo added");
            }
        });

        // Pagination
        Pagination pagination = new Pagination(5, 0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(pageIndex);
            }
        });
        grid.add(pagination, 0, 1, 2, 1);

        // Logout button
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

        return new Scene(grid, 400, 400);
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
     memo: momo changed May 2nd, May 3rd
     ***************************************************************************/
        public Scene loginScene()
    {
        // Set margin / space
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add create new account button
        Button btnNew = new Button("New account");
        Button btnSignin = new Button("Sign in");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnSignin);
        hbBtn.getChildren().add(btnNew);

        grid.add(hbBtn, 1,4);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
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

        // User name
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        // password
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);


        btnSignin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e)
            {
                String username = String.valueOf(userTextField.getText());
                String password = String.valueOf(pwBox.getText());
                Database db = Database.sharedInstance();
                if(db.isUserExists(username, password))
                {
                    stage.setTitle("Index");
                    stage.setScene(indexScene());
                } else {
                    stage.setTitle("New account");
                    actiontarget.setText("You don't have your account.\nplease click \"create new account\"");
                }
            }
        });


        Scene scene = new Scene(grid, 350, 280);
        return scene;
    }

    /***************************************************************************
     Screen mame: Logout
     Description: Get Logout scene
     ***************************************************************************/
    public Scene logoutScene()
    {
        // Set margin / space
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
