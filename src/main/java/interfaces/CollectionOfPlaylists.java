package interfaces;

import java.util.ArrayList;
import java.util.List;
import edu.ithaca.autodj.Song;

import edu.ithaca.autodj.PlaylistLinkedNode;

public interface CollectionOfPlaylists<Playlist> {
/** think about implementing as HashMap */

    /**
     * @post returns the name and duration of all the playlists in the collection
     */
    String TotalNameAndDuration();
    
    /** 
     * @post returns all the songs in a playlist in the collection
     */
    String SongsInPlaylist(Playlist playlist);

    /**
     * @post removes a playlist from the collection
     */

    void removePlaylist(Playlist playlist);

    /**
     * @post adds a new playlist to the collection
     */
    void addPlaylist(PlaylistLinkedNode playlist);

    
    /**
     * @post removes song from all playlists in the collection
     */
    void removeSongFromAll(Song song);

    /** 
     * @post make a random playlist of songs adding up to a certain duration
     */
    int makeRandomPlaylistCollectionOfLength(List<Song> library, String playlistName, int duration_in_seconds);
}
