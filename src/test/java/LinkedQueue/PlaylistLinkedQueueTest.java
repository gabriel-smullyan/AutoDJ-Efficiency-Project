package LinkedQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.ithaca.autodj.*;
import edu.ithaca.autodj.data.SongDataIO;
import interfaces.Playlist;

public class PlaylistLinkedQueueTest {
    
    @Test
    public void addAndRemoveSongTest(){
        Playlist<Song> myPlaylist = new PlaylistLinkedQueue();
        assertEquals(0, myPlaylist.getSize());
        Song mySong = new Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        myPlaylist.addSong(mySong);
        assertEquals(1, myPlaylist.getSize());
        myPlaylist.removeSong(mySong);
        assertEquals(0, myPlaylist.getSize());
        assertThrows(NoSuchElementException.class, () -> {
            myPlaylist.removeSong(mySong);
        });
    }

    @Test
    public void playNextTest(){
        Playlist<Song> myPlaylist = new PlaylistLinkedQueue();
        Song song1 = new Song("Future", "Mask Off", 203, 5, 0, 0, 0, 0);
        Song song2 = new Song("2Pac", "California Love", 285, 3, 0, 0, 0, 0);
        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        assertEquals(song1, myPlaylist.playNext());
        assertEquals(song2, myPlaylist.playNext());
    }

    @Test
    public void durationTest(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistLinkedQueue playlist = new PlaylistLinkedQueue();
        assertEquals(0, playlist.duration());
        playlist.addSong(song1);
        assertEquals(100, playlist.duration());
        playlist.addSong(song2);
        assertEquals(200, playlist.duration());
        playlist.addSong(song3);
        assertEquals(300, playlist.duration());    }

    @Test
    public void allSongsTest(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistLinkedQueue playlist = new PlaylistLinkedQueue();
        assertEquals("", playlist.allSongs());
        playlist.addSong(song1);
        assertEquals("Song1 by Artist1: 100\n", playlist.allSongs());
        playlist.addSong(song2);
        assertEquals("Song1 by Artist1: 100\nSong2 by Artist2: 100\n", playlist.allSongs());
        playlist.addSong(song3);
        assertEquals("Song1 by Artist1: 100\nSong2 by Artist2: 100\nSong3 by Artist3: 100\n", playlist.allSongs());
    }

    @Test
    public void addSongToStartTest(){
        Song song1 = new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0);
        Song song2 = new Song("Artist2", "Song2", 100, 0, 0, 0, 0, 0);
        Song song3 = new Song("Artist3","Song3", 100, 0, 0, 0, 0, 0);
        PlaylistLinkedQueue playlist = new PlaylistLinkedQueue();
        assertEquals(0, playlist.getSize());
        playlist.addSongToStart(song1);
        assertEquals(1, playlist.getSize());
        assertEquals("Song1 by Artist1: 100\n", playlist.allSongs());
        playlist.addSongToStart(song2);
        assertEquals("Song2 by Artist2: 100\nSong1 by Artist1: 100\n", playlist.allSongs());
        playlist.addSongToStart(song3);
        System.out.println(playlist.allSongs());
        System.out.println(playlist.getSize());
        System.out.println(playlist.duration());
        assertEquals("Song3 by Artist3: 100\nSong2 by Artist2: 100\nSong1 by Artist1: 100\n", playlist.allSongs());
        assertEquals(3, playlist.getSize());

    }
}
