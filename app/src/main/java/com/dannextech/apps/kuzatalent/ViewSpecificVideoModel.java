package com.dannextech.apps.kuzatalent;

public class ViewSpecificVideoModel {

    String path, talent,description,title,sender;

    public ViewSpecificVideoModel() {
    }

    public ViewSpecificVideoModel(String path, String talent, String description, String title, String sender) {

        this.path = path;
        this.talent = talent;
        this.description = description;
        this.title = title;
        this.sender = sender;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
