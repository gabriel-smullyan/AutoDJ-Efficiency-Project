package interfaces;
import java.util.ArrayList;
import java.util.List;

public interface Library<Song> {
    /*think about implementing as HashMap for easy access of keys */
    /**
     * @post returns all the songs in the library in alphabetical order
     */
    String allSongsAlphabetical();

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
    void addAlbumOfSongs(ArrayList<Song> songs);

    /**
     * @post removes a collection of songs from the library
     */
    void removeAlbumOfSongs(ArrayList<Song> songs);

    /**
     * @post returns the size of the library - 0 when empty and 1+ when not empty
     */
    int getSize();

}
