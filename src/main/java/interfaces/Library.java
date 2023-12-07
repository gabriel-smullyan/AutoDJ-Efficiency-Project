package interfaces;

import java.util.List;

public interface Library {
    /*think about implementing as ArrayList for easy access of indices */
    /**
     * @post returns all the songs in the library in alphabetical order
     */
    String allSongsAlpabetical();

    /** 
     * @post returns a Song within the library
     */
    Song getSong(String songName);

    /**
     * @post adds a song to the library
     */
    void addSong(Song song);

    /**
     * @post removes a song from the library
     */
    void removeSong(String songName);

    /**
     * @post adds an collection of songs to the library
     */
    void addAlbumOfSongs(List<Song> songs);

    /**
     * @post removes a collection of songs from the library
     */
    void removeAlbumOfSongs(List<Song> songs);
}
