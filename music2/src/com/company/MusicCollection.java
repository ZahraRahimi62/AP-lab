package com.company;
import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file information of music files.
    private ArrayList<Singer> files;
    // An ArrayList for storing the favorite file of music files.
    private ArrayList<Singer> favoriteFiles ;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<Singer>();
        favoriteFiles = new ArrayList<Singer>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(Singer filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index == 0)
            System.out.printf("The first file is: ");
        else if(index == 1)
            System.out.printf("The second file is: ");
        else if(index == 2)
            System.out.printf("The third file is: ");
        else
            System.out.printf("The %dth file is: ", index+1);
        System.out.println("The file' s name: " + files.get(index).getName() + ", The address of file:  " + files.get(index).getFile());
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(int i=0 ; i < files.size() ; i++){
            System.out.println("index of file is : " + " " + (i+1) + ", the file's name is: " + files.get(i).getName() + ", the address of file" + files.get(i).getFile());
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(Singer  index)
    {
        files.remove(index);
        // Iterator<String> it = files.iterator();
//        for(int i=0;i<files.size();i++){
//            if(i == index)
//        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        Singer name = files.get(index);
        player.startPlaying(name);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    public boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        if(index < 0 || index >= files.size())
            return false;
        return true;
    }

    /**
     * @param favorite the file that is favorite
     */
    public void addToFavorite(Singer favorite){
        favoriteFiles.add(favorite);
        files.add(favorite);

    }

    /**
     * print the favorite files
     */
    public void printFavorite(){
        for(int i=0 ; i < favoriteFiles.size() ; i++){
            System.out.println("This is favorite music " + ", index of file is : " + " " + (i+1) + ", the file's name is: " + favoriteFiles.get(i).getName() + ", the address of file" + favoriteFiles.get(i).getFile());
        }
    }

    /**
     * the string that we search for it
     * @param string
     */
    public void search(String string){
        for(int i=0 ; i < files.size() ; i++ ){
            if(files.get(i).getFile().equals(string) || files.get(i).getName().equals(string))
                System.out.println("The file's name is: " + files.get(i).getName() + ", the address of file" + files.get(i).getFile());
        }
    }

}
