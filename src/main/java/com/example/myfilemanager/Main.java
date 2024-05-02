package com.example.myfilemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {
    // 現在見ているディレクトリ
    static String currentDirectory = "";

    @Override
    public void start(Stage stage) throws IOException {
        // デフォルトのタイトルバーの非表示
        stage.initStyle(StageStyle.UNDECORATED);

        // デフォルトカレントディレクトリの設定
        String userHome = System.getProperty("user.home");
        Path downloadPath = Paths.get(userHome, "Downloads");
        currentDirectory = downloadPath.toString();

        // fxmlファイル(GUI)のロード
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ui.fxml"));
        VBox root = fxmlLoader.load();

        // ファイルとディレクトリの取得
        MyController controller = fxmlLoader.getController();
        ListView mainView = controller.getMainView();
        /*
        try {
            List<Path> items = FileManage.listFD(currentDirectory);
            for (Path item : items) {
                mainView.getItems().add(item.getFileName().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // シーンの作成と表示

        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void setupScreen() {

    }

    public static void main(String[] args) {
        launch();
    }
}
