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
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // デフォルトのタイトルバーの非表示
        stage.initStyle(StageStyle.UNDECORATED);

        // fxmlファイル(GUI)のロード
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ui.fxml"));
        VBox root = fxmlLoader.load();

        // ファイルとディレクトリの取得
        ListView<String> fileList = new ListView<>();
        try {
            List<Path> items = FileManage.listFD("C:\\Users\\naito\\Downloads");
            for (Path item : items) {
                fileList.getItems().add(item.toString());
                System.out.println(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyController controller = fxmlLoader.getController();
        VBox mainVBox = controller.getMainVBox();

        mainVBox.getChildren().add(fileList);

        // シーンの作成と表示

        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}