package com.example.cleaner.contoller;

import com.example.cleaner.model.Files;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface FileController {
    @GetMapping(value = "/getFile/{*path}")
    @ResponseBody List<Files> getFiles(@PathVariable String path);

    @GetMapping("/delete/{*path}")
     ResponseEntity<?> delete(@PathVariable("path") String path);

}
