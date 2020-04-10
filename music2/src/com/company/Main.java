package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        Singer singer1 = new Singer("D:/newFolder/", "Shajarian", "1380/12/03");
        Singer singer2 = new Singer("D:/newFolder/newFolder2", "Shajarian", "1390/08/15");
        Singer singer3 = new Singer("D:/newFolder/newFolder3", "Shajarian", "1385/09/23");
        pop.addFile(singer1);
        jazz.addFile(singer1);
        rock.addFile(singer1);
        jazz.addFile(singer3);
        jazz.addFile(singer2);
        country.addFile(singer1);
        //add song to favorites
        country.addToFavorite(singer1);
        country.printFavorite();
        //remove a file
        jazz.removeFile(singer1);
        jazz.listAllFiles();
        // printing the first file of pop
        pop.listFile(0);

        // print all files of jazz
        jazz.listAllFiles();
        // print all files of jazz
        rock.listAllFiles();
        // print all files of jazz
        country.listAllFiles();
        // print all shajarian' s
        jazz.search("Shajarian");
        //print the numbers of files of jazz
        System.out.println(jazz.getNumberOfFiles());
    }
}
