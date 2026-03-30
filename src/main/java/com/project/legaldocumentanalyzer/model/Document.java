package com.project.legaldocumentanalyzer.model;

public class Document {
    private String fileName;
    private String content;

    public Document() {
    }

    public Document(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}