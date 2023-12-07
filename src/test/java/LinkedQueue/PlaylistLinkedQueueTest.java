package LinkedQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.ithaca.autodj.*;
import interfaces.Playlist;

public class PlaylistLinkedQueueTest {
    
    @Test
    public void addAndRemoveSongTest(){
        Playlist<T> myPlaylist = new Playlist<>();
        Song mySong = Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        myQueue.enqueue(mySong);

        assertEquals("Mask Off by Future: 203", myPlaylist.removeSong(mySong));
    }

    @Test
    public void playNextTest(){
        Playlist<T> myPlaylist = new Playlist<>();
        Song song1 = Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        Song song2 = Song("2Pac", "California Love", 285, 3, 0, 0, 0, 0);
        
        assertEquals("California Love by 2Pac: 285", myPlaylist.playNext());
    }

    @Test
    public void durationTest(){
        NoSuchElementException("Not implemented yet");
    }

    @Test
    public void allSongsTest(){
        NoSuchElementException("Not implemented yet");
    }
}
