package interfaces;

import java.util.List;

public interface Playlist<Song> {
    /*thik about making a linked list and a Arraystack */
    /*
     * @post adds song to end of playlist
     */
    void addSong(Song song);

    /*
     * @post removes a specific song from playlist
     */
    void removeSong(Song song);

    /*
     * @post plays next song and removes current from playlist
     * @return song and info
     */
    public Song playNext();

    /*
     * @post returns total duration of playlist
     */

    int duration();

    /*
     * @post return a string of all songs in playlist
     */
    String allSongs();

    /*
     * @post returns size of playlist
     */
    int getSize();

    /*
     * @post adds song to start of playlist
     */
    void addSongToStart(Song song);
}


