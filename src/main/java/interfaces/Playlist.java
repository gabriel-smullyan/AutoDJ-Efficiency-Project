package interfaces;

public interface Playlist<T> {
    
    /*
     * @post adds song to end of playlist
     */
    void addSong(T song);

    /*
     * @post removes next song in playlist
     * @return song removed
     */
    T removeSong();

    /*
     * @post plays next song and removs current from playlist
     * @return song and info
     */
    T playNext();

    /*
     * @post returns total duration of playlist
     */

    T duration();

    /*
     * @post return a string of all songs in playlist
     */
    String allSongs();
}
