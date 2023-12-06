package com.example.cleaner.service;

import com.example.cleaner.model.Files;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class FileScanner implements Scanner {
    private final FileService fileService;

    public FileScanner(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public List<Files> scan(String path) {
        List<Files> list = new LinkedList<>();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            if (file.isFile()) {
                fileService.save(file.getPath(), file.getName());
                list.add(new Files(file.getPath(), file.getName()));
            }
        }
        return list;
    }
}
