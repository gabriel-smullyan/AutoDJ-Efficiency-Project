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
    public void removeSong(Song SongToRemove) {
        if (front == null){
            throw new NoSuchElementException("Playlist is empty");
        }

    while (front != null && front.getItem().equals(SongToRemove)) {
        front = front.getNext();
    }

    if (front == null) {
        end = null;
        return;
    }

    LinkedNode<Song> current = front;
    while (current.getNext() != null) {
        if (current.getNext().getItem().equals(SongToRemove)) {
            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) {
                end = current;
            }
        } else {
            current = current.getNext();
        }
    }
    }

    @Override
    public Song playNext() {
        if (front == null){
            throw new NoSuchElementException("Playlist is empty");
        }

        Song currentSong = front.getItem();
        front = front.getNext();

        return currentSong;
    }

    @Override
    public int duration() {
        if (front == null){
            return 0;
        }
        LinkedNode<Song> current = front;
        int duration = 0;

        while (current != null){
            duration += current.getItem().getDuration();

            if (current.getNext() == null){
                return duration;
            }
            current = current.getNext();
        }
        return duration;

        
    }

    @Override
    public String allSongs() {
        LinkedNode<Song> current = front;
        String allsongs = "";

        while (current != null){
            allsongs += current.getItem().toString() + "\n";

            if (current.getNext() == null){
                return allsongs;
            }
            current = current.getNext();
        }

        return allsongs;
    }
    
    @Override
    public int getSize(){
        LinkedNode<Song> current = front;
        if (front == null){
            return 0;
        }
        int size = 1;

        while (current.getNext() != null){
            size++;
            current = current.getNext();
        }

        return size;
    }

    @Override
    public void addSongToStart(Song song) {
        LinkedNode<Song> newSong = new LinkedNode<Song>(song);
        if (front == null){
            front = newSong;
            end = newSong;
        } else {
            newSong.setNext(front);
            front = newSong;
        }
    }
}
