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
    @Override
    public void addSong(Song song){
        playlist.add(song);
        size++;
        duration += song.getDuration();
    }
    @Override
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
    @Override
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
    @Override
    public int duration(){
        return duration;
    }

    @Override
    public String allSongs(){
        String temp = "";
        for (int i = 0; i < size; i++){
            temp += playlist.get(i).toString() + "\n";
        }
        return temp;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void addSongToStart(Song song){
        playlist.add(0, song);
        size++;
        duration += song.getDuration();
    }
}



   