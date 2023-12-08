package edu.ithaca.autodj;
import java.util.NoSuchElementException;

import interfaces.CollectionOfPlaylists;
import interfaces.Playlist;
import interfaces.Queue;

public class CollectionLinkedQueue implements CollectionOfPlaylists<Song>{

    private LinkedNode<Song> front;
    private LinkedNode<Song> end;

    public CollectionLinkedQueue(){
        front = null;
        end = null;
    }

}