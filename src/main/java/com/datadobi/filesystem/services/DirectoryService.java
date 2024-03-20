package com.datadobi.filesystem.services;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class DirectoryService {

    public static void createDirectoryFirst() {
        try {
            Path p = Paths.get("src/main/java/com/datadobi/filesystem/system1");
            if (Files.exists(p)) {
                System.out.println("already exists");
            } else {
                Path donePath = Files.createDirectories(p);
                System.out.println("succes at " + donePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDirectorySecond() {
        try {
            Path p = Paths.get("src/main/java/com/datadobi/filesystem/system2");
            if (Files.exists(p)) {
                System.out.println("already exists");
            } else {
                Path donePath = Files.createDirectories(p);
                System.out.println("succes at " + donePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
