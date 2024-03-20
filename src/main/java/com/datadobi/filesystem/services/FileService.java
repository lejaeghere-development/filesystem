package com.datadobi.filesystem.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
    public static void copieFirstFileToSecondFile() {
        try {
            Path source = Paths.get("src/main/java/com/datadobi/filesystem/system1/first.txt");
            Path destination = Paths.get("src/main/java/com/datadobi/filesystem/system1/second.txt");
            Files.copy(source, destination);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFileFirst() {
        try {
            Path p = Paths.get("src/main/java/com/datadobi/filesystem/system1/first.txt");
            if (Files.exists(p)) {
                System.out.println("already exists");
            } else {
                Path donePath = Files.createFile(p);
                System.out.println("succes at " + donePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFileThird() {
        try {
            Path p = Paths.get("src/main/java/com/datadobi/filesystem/system2/third.txt");
            if (Files.exists(p)) {
                System.out.println("already exists");
            } else {
                Path donePath = Files.createFile(p);
                System.out.println("succes at " + donePath.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void MoveFirstFileToOtherDirectory() {
        try {
            Path source = Paths.get("src/main/java/com/datadobi/filesystem/system1/first.txt");
            Path destination = Paths.get("src/main/java/com/datadobi/filesystem/system2/first.txt");
            Files.move(source, destination);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileFirst() {
        try {
            Path p = Paths.get("src/main/java/com/datadobi/filesystem/system1/first.txt");
            if (Files.exists(p)) {
                List<String> data = Files.readAllLines(p);
                for (String s : data) {
                    System.out.println(s);
                }
            } else {
                System.out.println("No such file was found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileFirst() {
        try {
            Path p = Paths.get("src/main/java/com/datadobi/filesystem/system1/first.txt");
            if (Files.exists(p)) {
                String content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
                Files.write(p, content.getBytes());
                System.out.println("Data written as byte array");
            } else {
                System.out.println("No such file was found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
