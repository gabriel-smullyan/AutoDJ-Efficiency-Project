package interfaces;

public interface CollectionOfPlaylists {
    /**
     * @post returns the name and duration of all the playlists in the collection
     */
    String TotalNameAndDuration();
    
    /** 
     * @post returns all the songs in a playlist in the collection
     */
    String SongsInPlaylist(String playlistName);

    /**
     * @post removes a playlist from the collection
     */

    void removePlaylist(String playlistName);

    /**
     * @post adds a new empty playlist to the collection
     */
    Playlist addPlaylist(String playlistName);

    
    /**
     * @post removes song from all playlists in the collection
     */
    void removeSongFromAll(String songName);

    /** 
     * @post make a random playlist of songs adding up to a certain duration
     */
    Playlist makeRandomPlaylistCollectionOfLength(String playlistName, int duration_in_seconds);
}
