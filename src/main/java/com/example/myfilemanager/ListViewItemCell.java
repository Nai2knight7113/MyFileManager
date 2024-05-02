package com.example.myfilemanager;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ListViewItemCell extends ListCell<Path> {
    // アイコンMap
    private final Map<String, String> iconMap = new HashMap<>();
    private final String defaultIcon = "default_icon.png";

    public ListViewItemCell() {
        iconMap.put(".txt", "txt_icon.png");
        iconMap.put(".png", "png_icon.png");
    }

    @Override
    protected void updateItem(Path item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            // ファイル名
            String fileName = item.getFileName().toString();
            setText(fileName);

            // 拡張子の取得
            String extension = fileName.substring(fileName.lastIndexOf("."));
            // 対応するアイコンを取得
            String iconPath = iconMap.getOrDefault(extension, defaultIcon);

            // ファイルアイコンのURL取得
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myfilemanager/" + iconPath));

            // ファイルアイコン
            ImageView icon = new ImageView(new Image(loader.getLocation().toString()));
            icon.setFitWidth(32);
            icon.setFitHeight(32);
            setGraphic(icon);
        }
    }
}
