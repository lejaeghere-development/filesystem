package com.datadobi.filesystem.services;

import com.datadobi.filesystem.depthsearchutil.DepthFirstSearchPreorder;
import com.datadobi.filesystem.depthsearchutil.GraphMock;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileSystemService {

    public static void createFileSystemFromExistingZipAndWriteHello() {
        Map<String, String> env = new HashMap<>();
        URI uri = URI.create("jar:file:/storage/ziptest.zip");
        try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
            Path nf = fs.getPath("aaa.txt");
            try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                writer.write("hello");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFileSystemFromNewZip() {
        try {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            // locate file system by using the syntax
            // defined in java.net.JarURLConnection
            URI uri = URI.create("jar:file:/storage/ziptest2.zip");
            FileSystem zipfs = FileSystems.newFileSystem(uri, env);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void putFileInZip() {
        try {
            Map<String, String> env = new HashMap<>();
            URI uriDest = URI.create("jar:file:/storage/ziptest.zip");
            FileSystem zipfs = FileSystems.newFileSystem(uriDest, env);
            Path source = Paths.get("C://storage/SomeTextFile.txt");
            Path destination = zipfs.getPath("/SometextFile");
            Files.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void AddSubdirectoryInZip() {
        Map<String, String> env = new HashMap<>();
        URI uri = URI.create("jar:file:/storage/ziptest.zip");

        try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
            Path directory = fs.getPath("/sub");
            Files.createDirectories(directory);
            Path nf = fs.getPath("/sub/new2.txt");
            try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                writer.write("hello");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listContent() {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry zipEntry;
        try {
            System.out.println("Files in the zip are as follows: ");
            fileInputStream = new FileInputStream("C://storage/ziptest.zip");
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());
            }
            zipInputStream.close();
        } catch (IOException fe) {
            fe.printStackTrace();
        }
    }

    public static void listContentOrderedOutput() {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry zipEntry;
        List<String> contentNames = new ArrayList<>();

        try {
            System.out.println("Files in the zip are as follows: ");
            fileInputStream = new FileInputStream("C://storage/ziptest.zip");
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                contentNames.add(zipEntry.getName());
            }
            zipInputStream.close();
        } catch (IOException fe) {
            fe.printStackTrace();
        }

        Collections.sort(contentNames);


        contentNames.forEach(System.out::println);
    }

    public static void listContentDepthFirst() {
        int i = 0;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry zipEntry;
        List<String> zipEntries = new ArrayList<>();

        try {

            fileInputStream = new FileInputStream("C://storage/ziptest.zip");
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                zipEntries.add(zipEntry.getName());
            }
            zipInputStream.close();
        } catch (IOException fe) {
            fe.printStackTrace();
        }
        List<List<String>> filteredEntries = new ArrayList<>();
        Collections.sort(zipEntries);
        zipEntries.forEach(System.out::println);
        DepthFirstSearchPreorder.dfsRecursive(GraphMock.tempCreateGraphMock());

    }

    public void readFileSystem() {
        try (Stream<Path> paths = Files.walk(Paths.get("hello"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
