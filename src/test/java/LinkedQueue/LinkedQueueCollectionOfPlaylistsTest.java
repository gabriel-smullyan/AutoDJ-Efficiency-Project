package LinkedQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.ithaca.autodj.*;
import interfaces.CollectionOfPlaylists;

public class LinkedQueueCollectionOfPlaylistsTest {
    
    @Test
    public void testAddAndTotalDurationPlaylist() {
        CollectionLinkedQueue collection = new CollectionLinkedQueue();
        PlaylistArrayList playlist1 = new PlaylistArrayList();
        PlaylistArrayList playlist2 = new PlaylistArrayList();
        PlaylistArrayList playlist3 = new PlaylistArrayList();
        playlist1.addSong(new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0));
        playlist2.addSong(new Song("Artist2", "Song2", 101, 0, 0, 0, 0, 0));
        playlist3.addSong(new Song("Artist3", "Song3", 102, 0, 0, 0, 0, 0));
        PlaylistLinkedNode<PlaylistArrayList> playlist1_node = new PlaylistLinkedNode(playlist1);
        PlaylistLinkedNode<PlaylistArrayList> playlist2_node = new PlaylistLinkedNode(playlist2);
        PlaylistLinkedNode<PlaylistArrayList> playlist3_node = new PlaylistLinkedNode(playlist3);
        collection.addPlaylist(playlist1_node);
        collection.addPlaylist(playlist2_node);
        collection.addPlaylist(playlist3_node);
        assertEquals("Song1 by Artist1: 100\nSong2 by Artist2: 101\nSong3 by Artist3: 102\n", collection.TotalNameAndDuration());
    }

    @Test
    public void testAddAndRemovePlaylist() {
        CollectionLinkedQueue collection = new CollectionLinkedQueue();
        PlaylistArrayList playlist1 = new PlaylistArrayList();
        PlaylistArrayList playlist2 = new PlaylistArrayList();
        PlaylistArrayList playlist3 = new PlaylistArrayList();
        playlist1.addSong(new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0));
        playlist2.addSong(new Song("Artist2", "Song2", 101, 0, 0, 0, 0, 0));
        playlist3.addSong(new Song("Artist3", "Song3", 102, 0, 0, 0, 0, 0));
        PlaylistLinkedNode<PlaylistArrayList> playlist1_node = new PlaylistLinkedNode(playlist1);
        PlaylistLinkedNode<PlaylistArrayList> playlist2_node = new PlaylistLinkedNode(playlist2);
        PlaylistLinkedNode<PlaylistArrayList> playlist3_node = new PlaylistLinkedNode(playlist3);
        collection.addPlaylist(playlist1_node);
        collection.addPlaylist(playlist2_node);
        collection.addPlaylist(playlist3_node);
        collection.removePlaylist(playlist2);
        assertEquals("Song1 by Artist1: 100\nSong3 by Artist3: 102\n", collection.TotalNameAndDuration());
    }
    
    @Test
    public void testSongsInPlaylist() {
        CollectionLinkedQueue collection = new CollectionLinkedQueue();
        PlaylistArrayList playlist1 = new PlaylistArrayList();
        PlaylistArrayList playlist2 = new PlaylistArrayList();
        PlaylistArrayList playlist3 = new PlaylistArrayList();
        playlist1.addSong(new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0));
        playlist2.addSong(new Song("Artist2", "Song2", 101, 0, 0, 0, 0, 0));
        playlist3.addSong(new Song("Artist3", "Song3", 102, 0, 0, 0, 0, 0));
        PlaylistLinkedNode<PlaylistArrayList> playlist1_node = new PlaylistLinkedNode(playlist1);
        PlaylistLinkedNode<PlaylistArrayList> playlist2_node = new PlaylistLinkedNode(playlist2);
        PlaylistLinkedNode<PlaylistArrayList> playlist3_node = new PlaylistLinkedNode(playlist3);
        collection.addPlaylist(playlist1_node);
        collection.addPlaylist(playlist2_node);
        collection.addPlaylist(playlist3_node);
        assertEquals("Song1 by Artist1: 100\n", collection.SongsInPlaylist(playlist1));
    }

    @Test
    public void testAddAndRemoveSongFromAll() {
        CollectionLinkedQueue collection = new CollectionLinkedQueue();
        PlaylistArrayList playlist1 = new PlaylistArrayList();
        PlaylistArrayList playlist2 = new PlaylistArrayList();
        PlaylistArrayList playlist3 = new PlaylistArrayList();
        Song song2 = new Song("Artist2", "Song2", 101, 0, 0, 0, 0, 0);
        playlist1.addSong(new Song("Artist1", "Song1", 100, 0, 0, 0, 0, 0));
        playlist2.addSong(song2);
        playlist3.addSong(new Song("Artist3", "Song3", 102, 0, 0, 0, 0, 0));
        PlaylistLinkedNode<PlaylistArrayList> playlist1_node = new PlaylistLinkedNode(playlist1);
        PlaylistLinkedNode<PlaylistArrayList> playlist2_node = new PlaylistLinkedNode(playlist2);
        PlaylistLinkedNode<PlaylistArrayList> playlist3_node = new PlaylistLinkedNode(playlist3);
        collection.addPlaylist(playlist1_node);
        collection.addPlaylist(playlist2_node);
        collection.addPlaylist(playlist3_node);
        collection.removeSongFromAll(song2);
        assertEquals("Song1 by Artist1: 100\nSong3 by Artist3: 102\n", collection.TotalNameAndDuration());
    }

    
}
