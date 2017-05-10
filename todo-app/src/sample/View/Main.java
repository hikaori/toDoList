package sample.View;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import sample.Model.Database;
import sample.Model.Todo;
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

        // Password verify
        Label pw2 = new Label("verify");
        grid.add(pw2,0,3);
        PasswordField pwBox2 = new PasswordField();
        grid.add(pwBox2,1,3);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


//                //check password value
//                boolean checkPassword = true;
//                if(!pwBox.equals(checkPassword)) {
//                    actiontarget.setFill(Color.FIREBRICK);
//                    actiontarget.setText("Password must be \r 6 - 10 characters long");
//                }

                if(pwBox.getText().equals(pwBox2.getText())) {
                    //add new account
                    Database mydb = Database.sharedInstance();
                    mydb.createUserAccount(userTextField.getText(), pwBox.getText());

                    // Go to login scene
                    stage.setTitle("Login");
                    stage.setScene(loginScene());

                }
                //check verify
                else if(!pwBox.getText().equals(pwBox2.getText())){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Type same password to verify");
                }
            }
        });

        return new Scene(grid, 300, 275);
    }

//    //--BOOLEAN CHECK PW
//    public static boolean checkPassword(PasswordField pwBox){
//        int length;
//        length = pwBox.getLength();
//        if (length < 6 || length > 11){
//            return false;
//        }
//        for (int i = 0; i < pwBox.getLength();i++){
//            if (!Character.isLetter(pwBox.getLength()))
//            return false;
//        }
//        return true;
//    }


    /***************************************************************************
     Screen name: Index
     Description: Get Index scene
     ***************************************************************************/
    // public Scene indexScene()
    public Scene indexScene(User user, Database db) //Momo put

    {
        final Random rng = new Random();
        VBox vPane = new VBox(5);
        ScrollPane sp = new ScrollPane(vPane);
        sp.setFitToWidth(true);

        // Input field
        TextField txtfTodo = new TextField();

        // Add todo list cards
        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(e -> {
            String txtftodo = String.valueOf(txtfTodo.getText()); // momo put
            AnchorPane ap = new AnchorPane();
//            String style = String.format("-fx-background: rgb(%d, %d, %d);"+
//                            "-fx-background-color: -fx-background;",
//                    rng.nextInt(256),
//                    rng.nextInt(256),
//                    rng.nextInt(256));
//            anchorPane.setStyle(style);
            Label label = new Label("Pane "+(vPane.getChildren().size()+1) +" : "+ txtftodo); // momo put
            AnchorPane.setLeftAnchor(label, 5.0);
            AnchorPane.setTopAnchor(label, 5.0);
            Button button = new Button("Remove");
            button.setOnAction(evt -> vPane.getChildren().remove(ap));
            AnchorPane.setRightAnchor(button, 5.0);
            AnchorPane.setTopAnchor(button, 5.0);
            AnchorPane.setBottomAnchor(button, 5.0);
            ap.getChildren().addAll(label, button);
            vPane.getChildren().add(ap);

        });

        // Textfield and add button
        VBox vHeader = new VBox();
        AnchorPane apHeader = new AnchorPane();
        AnchorPane.setLeftAnchor(txtfTodo, 5.0);
        AnchorPane.setTopAnchor(txtfTodo, 5.0);
        AnchorPane.setRightAnchor(btnAdd, 5.0);
        AnchorPane.setTopAnchor(btnAdd, 5.0);
        AnchorPane.setBottomAnchor(btnAdd, 5.0);
        apHeader.getChildren().addAll(txtfTodo, btnAdd);
        vHeader.getChildren().add(apHeader);

        // Logout button
        VBox vFooter = new VBox();
        Button btnLogout = new Button("Logout");
        AnchorPane apFooter = new AnchorPane();
        AnchorPane.setRightAnchor(btnLogout, 5.0);
        AnchorPane.setTopAnchor(btnLogout, 5.0);
        AnchorPane.setBottomAnchor(btnLogout, 5.0);
        apFooter.getChildren().addAll(btnLogout);
        vFooter.getChildren().add(apFooter);
        btnLogout.setOnAction(e -> {

            // Go to logout scene
            stage.setTitle("Logout");
            stage.setScene(logoutScene());
        });

        // momo put ----------
        ArrayList<Todo> userTODO = db.getUserTodos(user);
        for (Todo todo : userTODO) {
            String title = todo.getTitle();

            AnchorPane ap = new AnchorPane();
            Label label = new Label("Pane "+(vPane.getChildren().size()+1) +" : "+ title); // momo put
            AnchorPane.setLeftAnchor(label, 5.0);
            AnchorPane.setTopAnchor(label, 5.0);
            Button button = new Button("Remove");
            button.setOnAction(evt -> vPane.getChildren().remove(ap));
            AnchorPane.setRightAnchor(button, 5.0);
            AnchorPane.setTopAnchor(button, 5.0);
            AnchorPane.setBottomAnchor(button, 5.0);
            ap.getChildren().addAll(label, button);
            vPane.getChildren().add(ap);
        }
        // momo put end------

        return new Scene(new BorderPane(sp, vHeader, null, vFooter, null), 700, 400);
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
                    User user = new User(username, password);
                    stage.setTitle("Index");
                    stage.setScene(indexScene(user,db));
                } else {
                    stage.setTitle("New account");
                    actiontarget.setText("You don't have your account.\nTry again or create \"New account\"");
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


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e)
            {
//                actiontarget.setFill(Color.FIREBRICK);
//                actiontarget.setText("Create account button pressed");

                // Go to create account scene
                stage.setTitle("login");
                stage.setScene(loginScene());
            }
        });

        Scene scene = new Scene(grid, 350, 280);
        return scene;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}