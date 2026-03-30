package com.project.legaldocumentanalyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DashboardController {

    @GetMapping("/dashboard-data")
    public Map<String, Object> getDashboardData() {

        Map<String, Object> data = new HashMap<>();

        int total = DocumentController.documents.size();

        int analyzed = 0;
        for (Map<String, String> doc : DocumentController.documents) {
            if ("Analyzed".equals(doc.get("status"))) {
                analyzed++;
            }
        }

        int pending = total - analyzed;

        data.put("totalDocs", total);
        data.put("analyzed", analyzed);
        data.put("pending", pending);
        data.put("documents", DocumentController.documents);

        return data;
    }

}