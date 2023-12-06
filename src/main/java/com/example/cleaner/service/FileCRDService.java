package com.example.cleaner.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileCRDService implements FileCRD {


    @Override
    public File createDir(String path, String name) {
        File file = new File(path + "/" + name);
        file.mkdir();
        return file;
    }

    @Override
    public File createFile(String path, String name) throws IOException {
        File dest = new File(path + "/" + name);
        dest.createNewFile();
        return dest;
    }
}
