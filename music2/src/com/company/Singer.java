package com.company;

public class Singer {
    // the information of each singer
    private String file, name, date;

    public Singer(String file, String name, String date) {
        this.file = file;
        this.name = name;
        this.date = date;
    }

    /**
     * get the file address
     * @return the file field
     */
    public String getFile() {
        return file;
    }

    /**
     * get the name
     * @return the name field
     */
    public String getName() {
        return name;
    }

    /**
     * get the date
     * @return the date field
     */
    public String getDate() {
        return date;
    }
}
