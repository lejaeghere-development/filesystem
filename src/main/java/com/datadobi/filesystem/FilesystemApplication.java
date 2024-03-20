package com.datadobi.filesystem;

import com.datadobi.filesystem.services.FileSystemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilesystemApplication.class, args);
		FileSystemService.createFileSystemFromExistingZipAndWriteHello();
		FileSystemService.createFileSystemFromNewZip();
		FileSystemService.AddSubdirectoryInZip();
		FileSystemService.listContent();
//		FileSystemService.listContentOrderedOutput();
//		FileSystemService.listContentDepthFirst();
	}

}
