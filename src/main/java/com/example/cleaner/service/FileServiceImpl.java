package com.example.cleaner.service;

import com.example.cleaner.model.Files;
import com.example.cleaner.repository.FileRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public Files findById(Long id) {
        return fileRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Files file) {
        fileRepository.delete(file);
    }

    @Override
    public void deleteAll() {
        fileRepository.deleteAll();
    }

    @Override
    public List<Files> findAll() {
        return fileRepository.findAll();
    }

    @Override
    public Files save(String path, String name) {
        Files file = new Files();
        file.setPath(path);
        file.setName(name);
        file.setExtension(FilenameUtils.getExtension(name));
        return fileRepository.save(file);
    }
}
