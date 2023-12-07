package edu.ithaca.autodj;
import java.util.ArrayList;
import interfaces.*;

public class PlaylistArrayList implements Playlist<Song>{
    private ArrayList<Song> playlist;
    private int size;
    private int duration;

    public PlaylistArrayList(){
        playlist = new ArrayList<Song>();
        size = 0;
        duration = 0;
    }

    public void addSong(Song song){
        playlist.add(song);
        size++;
        duration += song.getDuration();
    }

    public void removeSong(Song song){
        if (size == 0){
            throw new IllegalArgumentException("Playlist is empty");
        }
        for (int i = 0; i < size; i++){
            if (playlist.get(i).equals(song)){
                playlist.remove(i);
                size--;
                duration -= song.getDuration();
            }
        }
    }

    public Song playNext(){
        if (size == 0){
            throw new IllegalArgumentException("Playlist is empty");
        }
        Song temp = playlist.get(0);
        playlist.remove(0);
        size--;
        duration -= temp.getDuration();
        return temp;
    }

    public int duration(){
        return duration;
    }


    public String allSongs(){
        String temp = "";
        for (int i = 0; i < size; i++){
            temp += playlist.get(i).getTitle() + " by " + playlist.get(i).getArtist() + "\n";
        }
        return temp;
    }

    public int getSize(){
        return size;
    }
}



   