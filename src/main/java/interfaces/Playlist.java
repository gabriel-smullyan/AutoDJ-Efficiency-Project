package interfaces;

public interface Playlist<Song> {
    
    /*
     * @post adds song to end of playlist
     */
    void addSong(Song song);

    /*
     * @post removes next song in playlist
     * @return string of song removed
     */
    void removeSong(Song song );

    /*
     * @post plays next song and removes current from playlist
     * @return song and info
     */
    Song playNext();

    /*
     * @post returns total duration of playlist
     */

    int totalDuration();

    /*
     * @post return a string of all songs in playlist
     */
    String allSongs();

    /*
     * @post adds song to start of playlist
     */
    void addSongToStart(Song song);


    /*
     * @post returns the size of the playlist - 0 when empty and 1+ when not empty
     */
    int getSize();
}

