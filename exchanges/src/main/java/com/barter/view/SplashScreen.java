package com.barter.view;

import java.net.URL;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen extends Application {
    private Scene SplashScreenScene;
    public Stage SplashScreenStage;

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(18);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5FAF0;");


        URL url = getClass().getResource("/assets/images/images.png");

        ImageView logo = new ImageView();

        if (url != null) {
            Image img = new Image(url.toExternalForm());
            logo.setImage(img);
            logo.setFitHeight(100);
            logo.setPreserveRatio(true);
        }


        Label name = new Label("BarterHub");
        name.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-text-fill: #1b4723;");

        Label tagline = new Label("Exchange More. Waste Less.");
        tagline.setStyle("-fx-font-size: 18px; -fx-text-fill: #1b4723;");

        Label description = new Label("Buy • Sell • Swap");
        description.setStyle("-fx-font-size: 14px; -fx-text-fill: #555555;");


        ProgressIndicator loading = new ProgressIndicator();
        loading.setPrefSize(35, 35);


        root.getChildren().addAll( logo, name, tagline, description, loading);


        SplashScreenStage = stage;
        Scene scene = new Scene(root, 1400, 700);
        scene.setFill(Paint.valueOf("#F5FAF0"));

        SplashScreenScene = scene;
        SplashScreenStage.setScene(SplashScreenScene);
        SplashScreenStage.setTitle("BarterHub");
        SplashScreenStage.show();


        FadeTransition fade = new FadeTransition(Duration.seconds(1.2),root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();


        PauseTransition pause = new PauseTransition(Duration.seconds(2.5));
        pause.setOnFinished(event -> {
              LoginPage login = new LoginPage();
              SplashScreenStage.setScene(login.getLoginPageScene());
            System.out.println("Splash finished!");
        });

        pause.play();
        }
}