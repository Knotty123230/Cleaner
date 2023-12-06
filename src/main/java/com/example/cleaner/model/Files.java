package com.example.cleaner.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String name;
    private String extension;

    public Files() {
    }

    public Files(String path, String name) {
        this.path = path;
        this.name = name;
    }
}
