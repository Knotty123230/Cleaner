package com.example.cleaner.service;

import com.example.cleaner.model.Files;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FilePackaging implements Packaging {
    private final FileService fileService;
    private final FileCRD fileCRD;
    private final NameUtil nameUtil;

    public FilePackaging(FileService fileService, FileCRD fileCRD, NameUtil nameUtil) {
        this.fileService = fileService;
        this.fileCRD = fileCRD;
        this.nameUtil = nameUtil;
    }

    @Override
    public void run(String path) {
        List<Files> files = fileService.findAll();
        for (Files file : files) {
            File pdf = fileCRD.createDir(path, nameUtil.findName(file.getExtension()));
            try {
                File destFile = fileCRD.createFile(pdf.getPath(), file.getName());
                File srcFile = fileCRD.createFile(path, file.getName());
                FileUtils.copyFile(srcFile, destFile);
                srcFile.delete();
                fileService.deleteAll();
            } catch (IOException e) {
                continue;
            }
        }
    }
}
