package edu.ithaca.autodj;

public class LinkedNode<Song> {
    private Song item;
    private LinkedNode<Song> next;

    public LinkedNode(Song item){
        this(item, null);
    }

    public LinkedNode(Song item, LinkedNode<Song> next){
        this.item = item;
        this.next = next;
    }

    public void setNext(LinkedNode<Song> newSong){
        this.next = newSong;
    }

    public Song getItem(){
        return item;
    }

    public LinkedNode<Song> getNext(){
        return next;
    }

}
