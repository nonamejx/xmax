package com.nicestflower.xmax.ui.lesson;

import java.util.List;

public class Lesson {

    private String title;
    private List<String> fileLinks;
    private String size;
    private Boolean downloaded;

    public Lesson() {
    }

    public Lesson(String title, List<String> fileLinks, String size) {
        this.title = title;
        this.fileLinks = fileLinks;
        this.size = size;
        this.downloaded = false;
    }

    public Lesson(String title, List<String> fileLinks, String size, Boolean downloaded) {
        this.title = title;
        this.fileLinks = fileLinks;
        this.size = size;
        this.downloaded = downloaded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }

    public List<String> getFileLinks() {
        return fileLinks;
    }

    public void setFileLinks(List<String> fileLinks) {
        this.fileLinks = fileLinks;
    }
}
