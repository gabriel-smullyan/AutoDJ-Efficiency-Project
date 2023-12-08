package edu.ithaca.autodj;

public class PlaylistLinkedNode<Playlist> {
    private Playlist playlist;
    private PlaylistLinkedNode<Playlist> next;

    public PlaylistLinkedNode(Playlist playlistadded){
        playlist = playlistadded;
    }


    public void setNext(PlaylistLinkedNode<Playlist> newPlaylist){
        this.next = newPlaylist;
    }

    public Playlist getItem(){
        return playlist;
    }

    public PlaylistLinkedNode<Playlist> getNext(){
        return next;
    }

}