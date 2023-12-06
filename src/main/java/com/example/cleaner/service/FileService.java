package com.example.cleaner.service;

import com.example.cleaner.model.Files;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {
    Files findById(Long id);

    void delete(Files file);

    void deleteAll();

    List<Files> findAll();

    Files save(String path, String name);
}
