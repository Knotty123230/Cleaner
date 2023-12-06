package com.example.cleaner.service;

import org.springframework.stereotype.Service;

@Service
public class NameUtil {
    public String findName(String extension) {
        switch (extension) {
            case "pdf" -> {
                return "Docs";
            }
            case "dmg" -> {
                return "Loads";
            }
            case "doc" -> {
                return "Word";
            }
            case "docx" -> {
                return "Word";
            }
            case "exe" -> {
                return "applications";
            }
            case "icls" -> {
                return "themes jetbrains";
            }
            case "iso" -> {
                return "installation";
            }
            case "jar" -> {
                return "jarFiles";
            }
            case "java" -> {
                return "javaFiles";
            }
            case "jpg", "JPEG", "jpeg", "png" -> {
                return "PHOTO";
            }
            case "localized" -> {
                return "localized";
            }
            case "log" -> {
                return "logs";
            }
            case "mkv" -> {
                return "films";
            }
            case "mp4" -> {
                return "videos";
            }
            case "pptx" -> {
                return "presentations";
            }
            case "rtf" -> {
                return "rtf";
            }
            case "torrent" -> {
                return "torrent";
            }
            case "txt" -> {
                return "notes";
            }
            case "xlsx" -> {
                return "tables excel";
            }
            case "zip" -> {
                return "archives";
            }
            default -> {
                return "another";
            }
        }
    }
}
