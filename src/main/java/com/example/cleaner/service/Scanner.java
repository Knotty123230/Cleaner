package com.example.cleaner.service;

import com.example.cleaner.model.Files;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Scanner {
    List<Files> scan(String path);
}
