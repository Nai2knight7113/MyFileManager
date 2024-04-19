package com.example.myfilemanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
    // フィールド群
    public Pane TitlePane;
    public Pane MainPane;
    public Button ExitButton;
    public Button MinimizeButton;


    // Xボタンの処理
    @FXML
    protected void onExitButtonClick(ActionEvent e) {
        System.exit(0);
    }

    // ウィンドウ自体の移動
    private double windowXOffset = 0;
    private double windowYOffset = 0;

    @FXML
    protected void windowMovePressed(MouseEvent e) {
        Node source = (Node) e.getSource();
        windowXOffset = e.getScreenX() - source.getScene().getWindow().getX();
        windowYOffset = e.getScreenY() - source.getScene().getWindow().getY();
    }

    @FXML
    protected void windowMoveDragged(MouseEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        double x = e.getScreenX() - windowXOffset;
        double y = e.getScreenY() - windowYOffset;

        stage.setX(x);
        stage.setY(y);
    }

    // ウィンドウの最小化
    @FXML
    protected void windowMinimize(ActionEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.setIconified(true);
    }
}
