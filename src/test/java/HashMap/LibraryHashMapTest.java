package HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.ithaca.autodj.*;
import edu.ithaca.autodj.data.SongDataIO;
import interfaces.Library;
import java.util.ArrayList;


public class LibraryHashMapTest {

    @Test
    public void addAndRemoveSongTest(){
        Library<Song> myLibrary = new LibraryHashMap();
        assertEquals(0, myLibrary.getSize());
        Song mySong = new Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        myLibrary.addSong(mySong);
        assertEquals(1, myLibrary.getSize());
        myLibrary.removeSong(mySong.getTitle());
        assertEquals(0, myLibrary.getSize());
        assertThrows(IllegalArgumentException.class, () -> {
            myLibrary.removeSong(mySong.getTitle());
        });
    }

    @Test
    public void getSongTest(){
        Library<Song> myLibrary = new LibraryHashMap();
        Song mySong = new Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        myLibrary.addSong(mySong);
        assertEquals(mySong, myLibrary.getSong(mySong.getTitle()));
        assertThrows(IllegalArgumentException.class, () -> {
            myLibrary.getSong("Not a song");
        });
    }


    @Test
    public void addAndRemoveAlbumOfSongsTest(){
        Library<Song> myLibrary = new LibraryHashMap();
        Song mySong = new Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        Song mySong2 = new Song("Tupac", "California Love", 285, 3, 0, 0, 0, 0);
        ArrayList<Song> mySongs = new ArrayList<Song>();
        mySongs.add(mySong);
        mySongs.add(mySong2);
        myLibrary.addAlbumOfSongs(mySongs);
        assertEquals(mySong, myLibrary.getSong(mySong.getTitle()));
        assertEquals(mySong2, myLibrary.getSong(mySong2.getTitle()));
        myLibrary.removeAlbumOfSongs(mySongs);
        assertThrows(IllegalArgumentException.class, () -> {
            myLibrary.getSong(mySong.getTitle());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            myLibrary.getSong(mySong2.getTitle());
        });
    }

    @Test
    public void allSongsAlphabeticalTest(){
        Library<Song> myLibrary = new LibraryHashMap();
        Song mySong = new Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        Song mySong2 = new Song("Tupac", "California Love", 285, 3, 0, 0, 0, 0);
        Song mySong3 = new Song("Biggie", "Juicy", 302, 3, 0, 0, 0, 0);
        ArrayList<Song> mySongs = new ArrayList<Song>();
        mySongs.add(mySong);
        mySongs.add(mySong2);
        mySongs.add(mySong3);
        myLibrary.addAlbumOfSongs(mySongs);
        assertEquals("California Love by Tupac: 285\nJuicy by Biggie: 302\nMask Off by Future: 203\n", myLibrary.allSongsAlphabetical());
    }
   
}
