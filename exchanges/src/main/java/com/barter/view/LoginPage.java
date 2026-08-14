package com.barter.view;

import com.barter.controller.AuthController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LoginPage{
    private Scene LoginPageScene;
    Scene getLoginPageScene(){
        HBox whole = new HBox(280);
        VBox vbLeft = new VBox();
        VBox vbRight = new VBox(25);
        CheckBox remBox = new CheckBox("Remember me");

        HBox head = new HBox();
        Text head1 = new Text("Barter");
        head1.setStyle("-fx-font-size : 50px; -fx-font-weight : bold; -fx-fill : #2e4d16");

        Text head2 = new Text("Hub");
        head2.setStyle("-fx-font-size : 50px; -fx-font-weight : bold; -fx-fill : #8d7934");


        Text des = new Text("Exchange More.");
        des.setStyle("-fx-font-size : 30px; -fx-font-weight : bold; -fx-fill : #000000");
        des.setTranslateX(180);
        des.setTranslateY(40);


        Text des1 = new Text("Waste Less.");
        des1.setStyle("-fx-font-size : 30px; -fx-font-weight : bold; -fx-fill : #4f3607");
        des1.setTranslateX(180);
        des1.setTranslateY(30);


        Label des2 = new Label("Trade unused products with nearby people.\nSave money, reduced waste, and\nbuild a stronger community.");
        des2.setStyle("-fx-fill : #2d2d2d");
        des2.setTranslateX(180);
        des2.setTranslateY(40);


        Image img = new Image("assets\\images\\ChatGPT Image Aug 10, 2026, 10_24_01 PM.png");
        ImageView view = new ImageView(img);

        view.setFitHeight(600);
        view.setPreserveRatio(true);
        view.setTranslateX(180);
        view.setTranslateY(-70);

        Rectangle rec = new Rectangle(400, 400);
        view.setClip(rec);
        rec.setY(20);
        rec.setTranslateY(100);


        head.getChildren().addAll(head1, head2);
        head.setTranslateX(180);
        head.setTranslateY(40);

        //------------------------- VBRight is starting from below..--------------------------------------

        Text t1 = new Text("Welcome Back!");
        t1.setStyle("-fx-fill : black; -fx-font-size : 30px; -fx-font-weight : BOLD;");
        t1.setTranslateX(90);

        Label l1 = new Label("Login to continue your exchange journey");
        l1.setTranslateX(90);
        l1.setTranslateY(-30);

        HBox logUp = new HBox(80);
        logUp.setTranslateX(35);
        logUp.setTranslateY(-30);
        logUp.setMaxWidth(320);
        logUp.setPadding(new Insets(-2));
        logUp.setAlignment(Pos.CENTER);

        Button log = new Button("Login");
        log.setPrefWidth(250);
        Button sign = new Button("Sign Up");
        sign.setPrefWidth(250);


        log.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: blue;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight : bold;" +
            "-fx-border-color : blue;" +
            "-fx-border-width : 0 0 2px 0;"
        );
        

        sign.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: gray;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight : bold;"
        );

        Button login = new Button("Login ->]");
        HBox note = new HBox();
        Label l6 = new Label("Note : ");
        Label l7 = new Label("Enter your details below to signingUp");
        TextField email = new TextField();
        PasswordField pass = new PasswordField();
        AuthController controller = new AuthController();


        log.setOnAction(event -> {
            System.out.println("login is clicked!");
            sign.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: gray;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight : bold;" +
                "-fx-border-width : 0 0 2px 0;" +
                "-fx-border-color : transparent;"
            );

            log.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight : bold;" +
                "-fx-border-width : 0 0 2px 0;" +
                "-fx-border-color : blue;"
            );
            l6.setText(null);
            l7.setText(null);

            login.setText("Login ->]");

            login.setOnAction(e -> {
                boolean flag = controller.signIn(email.getText(), pass.getText());
                if(flag){
                    System.out.println("Sign in successfully");
                    email.setText("Success");
                    pass.setText(null);             
                }else{
                    System.out.println("Sign in Failed");
                    email.setText("Failed");
                    l7.setText("Invalid Credentials");
                    pass.setText(null);
                }
            });
        });


        sign.setOnAction(event -> {
            l7.setText(null);
            login.setText("Sign Up");
            System.out.println("sign up is clicked!");
            log.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight : bold;" +
                "-fx-border-width : 0 0 2px 0;" +
                "-fx-border-color : transparent;"
            );

            sign.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: gray;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight : bold;" +
                "-fx-border-width : 0 0 2px 0;" +
                "-fx-border-color : blue;"
            );

            l6.setText("Note : ");
            l6.setTextFill(Color.BLACK);

            l7.setText("Enter your details below to signingUp");
            l7.setTextFill(Color.RED);

            note.getChildren().addAll(l6, l7);
            note.setTranslateX(70);
            note.setTranslateY(-30);

            
            login.setOnAction(e -> {
                boolean flag = controller.signUp(email.getText(), pass.getText());
            if(flag){
                System.out.println("SignUp successfully");
                email.setText("Success");
                pass.setText(null);
            }else{
                System.out.println("Sign up failed!");
                email.setText("Failed");
                pass.setText(null);
                l7.setText("Invalid Credentials");
            }
            });
        });
        

        logUp.setStyle("-fx-border-width : 0 0 2px 0; -fx-border-color : lightgray");
        logUp.getChildren().addAll(log, sign);

        Label l2 = new Label("Email Address");
        l2.setTranslateY(-30);
        l2.setTranslateX(20);

        email.setTranslateY(-50);
        email.setMaxWidth(350);
        email.setTranslateX(15);
        email.setStyle("-fx-font-size : 14px");
        email.setPromptText("Enter your email");


        Label l3 = new Label("Password");
        l3.setTranslateX(20);
        l3.setTranslateY(-60);

        pass.setTranslateY(-80);
        pass.setMaxWidth(350);
        pass.setTranslateX(15);
        pass.setStyle("-fx-font-size : 14px");
        pass.setPromptText("Enter your password");

        Label l4 = new Label("Forgot Password?");
        l4.setTextFill(Color.BLUE);
        l4.setTranslateX(270);
        l4.setTranslateY(-100);

        
        remBox.setTranslateX(20);
        remBox.setTranslateY(-120);



        login.setStyle("-fx-background-color : blue; -fx-font-weight : bold; -fx-font-size : 16px");
        login.setMaxHeight(60);
        login.setMaxWidth(350);
        login.setTextFill(Color.WHITE);
        login.setTranslateX(20);
        login.setTranslateY(-120);

//---------------------------------- login setup---------------------------------------------
        login.setOnAction(e -> {
            l7.setText(null);
            boolean flag = controller.signIn(email.getText(), pass.getText());
            if(flag){
                System.out.println("Sign in successfully");
                email.setText("Success");
                pass.setText(null);              
            }else{
                System.out.println("Sign in Failed");
                email.setText("Failed");
                pass.setText(null);
                l7.setText("Invalid Credentials");
            }
        });

//-----------------------------------x----------x--------------------------------------------
        
        HBox line = new HBox(2);

        VBox l = new VBox();
        l.setStyle("-fx-border-width : 1 0 0 0px; -fx-border-color : gray;");
        l.setPrefWidth(70);
        l.setTranslateY(-2);

        VBox r = new VBox();
        r.setStyle("-fx-border-width : 1 0 0 0px; -fx-border-color : gray;");
        r.setTranslateY(-2);
        r.setPrefWidth(70);
       
        Label or = new Label("or sign in with");
        line.getChildren().addAll(l, or, r);
        line.setAlignment(Pos.BASELINE_CENTER);
        line.setTranslateY(-120);


        HBox acc = new HBox();
        Label l5 = new Label("Don't have a account?");
        l5.setStyle("-fx-font-size : 13px");

//-------------------------------signUp setup------------------------------------------------

        Button signUp = new Button(" Sign Up");
        signUp.setTextFill(Color.BLUE);
        signUp.setStyle("-fx-font-weight : bold; -fx-font-size : 12px; -fx-background-color : transparent;");
        signUp.setTranslateY(-4);
        signUp.setTranslateX(-5);


        signUp.setOnAction(e ->{
            login.setText("Sign Up");
            log.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight : bold;" +
                "-fx-border-width : 0 0 2px 0;" +
                "-fx-border-color : transparent;"
            );

            sign.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: gray;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight : bold;" +
                "-fx-border-width : 0 0 2px 0;" +
                "-fx-border-color : blue;"
            );

            
            l6.setText("Note : ");
            l6.setTextFill(Color.BLACK);
            
            l7.setText("Enter your details below to signingUp");
            l7.setTextFill(Color.RED);

            note.getChildren().addAll(l6, l7);
            note.setTranslateX(70);
            note.setTranslateY(-30);


            login.setOnAction(event -> {
                boolean flag = controller.signUp(email.getText(), pass.getText());
            if(flag){
                System.out.println("SignUp successfully");
                email.setText("Success");
                pass.setText(null);
            }else{
                System.out.println("Sign up failed!");
                email.setText("Failed");
                pass.setText(null);
            }
            });
        });

//----------------------------------------x---------------------x-------------------------------

        acc.getChildren().addAll(l5, signUp);
        acc.setTranslateX(100);
        acc.setTranslateY(-120);


        vbLeft.getChildren().addAll(head, des, des1, des2, view);
        vbRight.getChildren().addAll(t1, l1,logUp, note, l2, email, l3, pass, l4, remBox, login, line, acc);
        vbRight.setStyle("-fx-background-color : WHITE; -fx-padding : 30px; -fx-border-radius : 10px; -fx-background-radius : 10px; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.20), 15, 0, 0, 5);");
        vbRight.setPrefWidth(450);
        vbRight.setMaxHeight(600);
        vbRight.setTranslateY(20);
        

        whole.getChildren().addAll(vbLeft, vbRight);
        whole.setTranslateX(50);

        Group gr = new Group(whole);
        Scene sc = new Scene(gr, 1400, 700);
        sc.setFill(Color.web("#FCF8F3"));
        LoginPageScene = sc;

        return LoginPageScene;
    }
}