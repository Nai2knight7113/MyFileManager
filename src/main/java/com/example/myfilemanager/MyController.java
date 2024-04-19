package com.example.myfilemanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyController {
    // フィールド群
    public Pane TitlePane;
    public Pane MainPane;
    public Button ExitButton;
    public Button MinimizeButton;
    @FXML
    public VBox MainVBox;  // MainのScrollPane直下Box
    public VBox ListVBox;  // ListのScrollPane直下Box

    // MainVBox
    public VBox getMainVBox() {
        return MainVBox;
    }



    /* イベント処理 */

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
