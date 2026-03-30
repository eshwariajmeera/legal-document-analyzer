package com.project.legaldocumentanalyzer.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/document")
@CrossOrigin
public class DocumentController {

    public static List<Map<String, String>> documents = new ArrayList<>();

    @PostMapping("/upload")
    public Map<String, Object> uploadDocument(@RequestParam("file") MultipartFile file) {
        try {
            String content = new String(file.getBytes());

            int wordCount = content.split("\\s+").length;

            int agreement = content.toLowerCase().split("agreement", -1).length - 1;
            int clause = content.toLowerCase().split("clause", -1).length - 1;
            int penalty = content.toLowerCase().split("penalty", -1).length - 1;

            // SUMMARY
            String summary;
            if( content.length() > 200)
            {
                summary = content.substring(0, 200) + "...";
            }else {
                summary = content;
            }

            String fileName = file.getOriginalFilename();

            // STORE FOR DASHBOARD
            Map<String, String> docData = new HashMap<>();
            docData.put("name", fileName);
            docData.put("status", "Analyzed");
            documents.add(docData);

            // RESPONSE JSON
            Map<String, Object> response = new HashMap<>();
            response.put("fileName", fileName);
            response.put("wordCount", wordCount);
            response.put("agreement", agreement);
            response.put("clause", clause);
            response.put("penalty", penalty);
            response.put("summary", summary);

            return response;

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "File processing failed");
            return error;
        }
    }
}