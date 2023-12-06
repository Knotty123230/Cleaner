package com.example.cleaner.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public interface FileCRD {
    File createDir(String path, String name);

    File createFile(String path, String name) throws IOException;

}
