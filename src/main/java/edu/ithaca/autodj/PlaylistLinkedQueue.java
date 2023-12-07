package edu.ithaca.autodj;
import java.util.NoSuchElementException;

import interfaces.Playlist;
import interfaces.Queue;

public class PlaylistLinkedQueue implements Playlist<Song>{

    private LinkedNode<Song> front;
    private LinkedNode<Song> end;

    public PlaylistLinkedQueue(){
        front = null;
        end = null;
    }

    @Override
    public void addSong(Song mySong) {
        LinkedNode<Song> newSong = new LinkedNode<Song>(mySong);
        if (front == null){
            front = newSong;
            end = newSong;
        } else {
            end.setNext(newSong);
            end = newSong;
        }
    }

    @Override
    public String removeSong(Song SongToRemove) {
        if (front == null){
            throw new NoSuchElementException("Playlist is empty");
        }
        
        String songRemoved = front.getNext().getItem().toString();
        LinkedNode<Song> newNextSong = front.getNext().getNext();
        front.setNext(newNextSong);

        return songRemoved;
    }

    @Override
    public String playNext() {
        if (front == null){
            throw new NoSuchElementException("Playlist is empty");
        }

        String currentSong = front.getItem().toString();
        front = front.getNext();

        return currentSong;
    }

    @Override
    public int totalDuration() {
        LinkedNode<Song> current = front;
        int duration = 0;

        while (current.getNext() != null){
            duration+= current.getItem().getDuration();

            current.getNext();
        }

        return duration;
    }

    @Override
    public String allSongs() {
        LinkedNode<Song> current = front;
        String allsongs = "";

        while (current.getNext() != null){
            allsongs += current.getItem().toString() + "\n";
        }

        return allsongs;
    }
    
}
