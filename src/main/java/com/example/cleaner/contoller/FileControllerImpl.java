package com.example.cleaner.contoller;

import com.example.cleaner.model.Files;
import com.example.cleaner.service.Packaging;
import com.example.cleaner.service.Scanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class FileControllerImpl implements FileController {
    private final Scanner scanner;
    private final Packaging packaging;

    public FileControllerImpl(Scanner scanner, Packaging packaging) {
        this.scanner = scanner;
        this.packaging = packaging;
    }

    @Override
    public List<Files> getFiles(String path) {
        return scanner.scan(path);
    }

    @Override
    public ResponseEntity<?> delete(String path) {
        try {
            packaging.run(path);
            return ResponseEntity.ok("files deleted");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("error");
        }
    }
}
