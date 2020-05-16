package com.company;

// TODO: Phase2: uncomment this code

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        if(date != "")
            this.date = date;
        else
            this.date = new Date().toString();
    }

    public String getDate() {
        return date;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}

