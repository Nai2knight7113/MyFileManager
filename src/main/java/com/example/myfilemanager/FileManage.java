package com.example.myfilemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManage {
    public static List<Path> listFD(String directoryPath) throws IOException {
        Path directory = Paths.get(directoryPath);
        return Files.list(directory).toList();
    }
}
