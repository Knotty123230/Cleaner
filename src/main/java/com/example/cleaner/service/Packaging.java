package com.example.cleaner.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface Packaging {
    void run(String path) throws IOException;
}
