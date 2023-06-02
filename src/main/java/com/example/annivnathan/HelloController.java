package com.example.annivnathan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.annivnathan.Enigme.validate;

public class HelloController {
    @FXML
    private Button suivant1;

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;
    @FXML
    private TextField textfield3;
    @FXML
    private TextField textfield4;
    @FXML
    private TextField textfield5;
    @FXML
    private TextField textfield6;
    @FXML
    private TextField textfield7;

    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    public static int enigme;
    public void enigme1(ActionEvent event) throws IOException{
        primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
        switchSceneall("enigme  ("+enigme+").fxml");
        enigme+=1;

    }
    public void start(ActionEvent event) throws IOException{
        primaryStage =(Stage)((Node)event.getSource()).getScene().getWindow();
        switchSceneall("enigme  (1).fxml");
        enigme=2;
        Enigme.set();

    }

    public int verif(String answer){
        int yes=0;
        System.out.println(validate);
        if (answer.equals(Enigme.enigmeList.get(validate))){
            yes=1;
            suivant1.setDisable(false);
            validate+=1;
            System.out.println(validate);
        }
        else {
            yes = 0;
        }

        return yes;

    }

    public void valider1(ActionEvent event) throws IOException{
        String text = "";
        int yes=0;
            try {
                text = textfield1.getText();
                textfield1.setText("");
            }
            catch (NumberFormatException e){
                textfield1.setText("");
            }
            textfield1.setText("");
            verif(text);


    }


    public void switchSceneall(String fxml) throws IOException {
        FXMLLoader sce = new FXMLLoader(getClass().getResource(fxml));
        sce.setLocation(HelloApplication.class.getResource(fxml));
        root = sce.load();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}