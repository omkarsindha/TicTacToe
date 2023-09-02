package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Board {

    @FXML
    private Button a1;

    @FXML
    private Button a2;

    @FXML
    private Button a3;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button c1;

    @FXML
    private Button c2;

    @FXML
    private Button c3;

    @FXML
    private Label label;

    @FXML
    private Label p1Score;
    private int p1Sc = 0;
    @FXML
    private Label p2Score;
    private int p2Sc = 0;
    @FXML
    private Button restart;

    ArrayList<String> list = new ArrayList<>();


   private boolean cross;

    public void initialize() {
        cross = true;
        a1.setOnAction(event -> onChoose(a1));
        a2.setOnAction(event -> onChoose(a2));
        a3.setOnAction(event -> onChoose(a3));
        b1.setOnAction(event -> onChoose(b1));
        b2.setOnAction(event -> onChoose(b2));
        b3.setOnAction(event -> onChoose(b3));
        c1.setOnAction(event -> onChoose(c1));
        c2.setOnAction(event -> onChoose(c2));
        c3.setOnAction(event -> onChoose(c3));
        a1.setStyle("-fx-opacity: 1;");
        a2.setStyle("-fx-opacity: 1;");
        a3.setStyle("-fx-opacity: 1;");
        b1.setStyle("-fx-opacity: 1;");
        b2.setStyle("-fx-opacity: 1;");
        b3.setStyle("-fx-opacity: 1;");
        c1.setStyle("-fx-opacity: 1;");
        c2.setStyle("-fx-opacity: 1;");
        c3.setStyle("-fx-opacity: 1;");

    }

    public void onChoose(Button button){
        ImageView image;
        if(cross){
            image = new ImageView("x.png");
        }else{
            image = new ImageView("o.png");
        }
        System.out.println(cross+button.getId());
        list.add(cross+button.getId());
        image.setFitWidth(50);
        image.setFitHeight(50);
        button.setGraphic(image);
        button.setDisable(true);
        cross = !cross;
        checkWinner();
    }


    public void checkWinner(){
        String[][] combinations = {
                { "a1", "a2", "a3" },
                { "b1", "b2", "b3" },
                { "c1", "c2", "c3" },
                { "a1", "b1", "c1" },
                { "a2", "b2", "c2" },
                { "a3", "b3", "c3" },
                { "a1", "b2", "c3" },
                { "a3", "b2", "c1" }
        };
        for (String[] combination : combinations) {
            String position1 = combination[0];
            String position2 = combination[1];
            String position3 = combination[2];

            if (list.contains("true" + position1) &&
                    list.contains("true" + position2) &&
                    list.contains("true" + position3)) {
                    label.setText("Player 1 wins!");
                    p1Sc ++;
                    p1Score.setText(String.valueOf(p1Sc));
                    disableButtons();
                return;
            } else if (list.contains("false" + position1) &&
                    list.contains("false" + position2) &&
                    list.contains("false" + position3)) {
                    label.setText("Player 2 wins!");
                    p2Sc ++;
                    p2Score.setText(String.valueOf(p2Sc));
                    disableButtons();
                return;
            }
        }
        if (list.size() == 9) {
            label.setText("It's a draw!");
        }
    }

    public void restartClick(){


    }
    public void disableButtons(){
        a1.setDisable(true);
        a2.setDisable(true);
        a3.setDisable(true);
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setDisable(true);
        c1.setDisable(true);
        c2.setDisable(true);
        c3.setDisable(true);
    }

}