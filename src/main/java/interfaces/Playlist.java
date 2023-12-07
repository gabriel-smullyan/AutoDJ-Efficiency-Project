package interfaces;

public interface Playlist<T> {
    /*thik about making a linked list and a stack */
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
     * @post plays next song and removes current from playlist
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
