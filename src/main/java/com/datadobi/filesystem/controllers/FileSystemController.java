package com.datadobi.filesystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileSystemController {


    @PostMapping("/new/filesystem")
    @ResponseStatus(code = HttpStatus.CREATED)
    void newFileSystem() {
    }

    @PostMapping("/new/direcory")
    @ResponseStatus(code = HttpStatus.CREATED)
    void newDirectory() {
    }

}
