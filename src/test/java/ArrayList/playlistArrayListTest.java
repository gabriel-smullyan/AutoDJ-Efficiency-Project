package ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.util.NoSuchElementException;
import edu.ithaca.autodj.*;
import org.junit.jupiter.api.Test;


public class playlistArrayListTest {
    
    @Test
    public void testAddSong(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistArrayList playlist = new PlaylistArrayList();
        assertEquals(0, playlist.getSize());
        playlist.addSong(song1);
        assertEquals(1, playlist.getSize());
        playlist.addSong(song2);
        assertEquals(2, playlist.getSize());
        playlist.addSong(song3);
        assertEquals(3, playlist.getSize());

    }


    @Test
    public void testremoveSong(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistArrayList playlist = new PlaylistArrayList();
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.removeSong(song2);
        assertEquals("Song1 by Artist1: 100\nSong3 by Artist3: 100\n", playlist.allSongs());
        playlist.removeSong(song1);
        assertEquals("Song3 by Artist3: 100\n", playlist.allSongs());
        playlist.removeSong(song3);
        assertEquals("", playlist.allSongs());
        assertThrows(IllegalArgumentException.class, () -> {
            playlist.removeSong(song3);
        });
    }

    @Test
    public void testplayNext(){
        PlaylistArrayList playlist = new PlaylistArrayList();
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        playlist.addSong(song1);
        playlist.addSong(song2);
        Song nextSong = playlist.playNext();
        assertEquals(song1, nextSong);
        Song nextSong2 = playlist.playNext();
        assertEquals(song2, nextSong2);
        assertThrows(IllegalArgumentException.class, () -> {
            playlist.playNext();
        });
    }

    @Test
    public void testduration(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistArrayList playlist = new PlaylistArrayList();
        assertEquals(0, playlist.duration());
        playlist.addSong(song1);
        assertEquals(100, playlist.duration());
        playlist.addSong(song2);
        assertEquals(200, playlist.duration());
        playlist.addSong(song3);
        assertEquals(300, playlist.duration());

    }

    @Test
    public void testallSongs(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistArrayList playlist = new PlaylistArrayList();
        assertEquals("", playlist.allSongs());
        playlist.addSong(song1);
        assertEquals("Song1 by Artist1: 100\n", playlist.allSongs());
        playlist.addSong(song2);
        assertEquals("Song1 by Artist1: 100\nSong2 by Artist2: 100\n", playlist.allSongs());
        playlist.addSong(song3);
        assertEquals("Song1 by Artist1: 100\nSong2 by Artist2: 100\nSong3 by Artist3: 100\n", playlist.allSongs());

    }
    @Test 
    public void testAddSongToStart(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistArrayList playlist = new PlaylistArrayList();
        assertEquals(0, playlist.getSize());
        playlist.addSongToStart(song1);
        assertEquals(1, playlist.getSize());
        assertEquals("Song1 by Artist1: 100\n", playlist.allSongs());
        playlist.addSongToStart(song2);
        assertEquals("Song2 by Artist2: 100\nSong1 by Artist1: 100\n", playlist.allSongs());
        playlist.addSongToStart(song3);
        assertEquals("Song3 by Artist3: 100\nSong2 by Artist2: 100\nSong1 by Artist1: 100\n", playlist.allSongs());
        assertEquals(3, playlist.getSize());




    }
}
