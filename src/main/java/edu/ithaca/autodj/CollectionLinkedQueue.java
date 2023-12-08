package edu.ithaca.autodj;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import interfaces.CollectionOfPlaylists;
import interfaces.Playlist;

public class CollectionLinkedQueue implements CollectionOfPlaylists<PlaylistArrayList>{

    public PlaylistLinkedNode<PlaylistArrayList> front;
    public PlaylistLinkedNode<PlaylistArrayList> end;

    public CollectionLinkedQueue(){
        front = null;
        end = null;
    }

    @Override
    public String TotalNameAndDuration(){
        PlaylistLinkedNode<PlaylistArrayList> current = front;
        String namesAndDurations = "";

        while (current != null){
            namesAndDurations += current.getItem().allSongs();

            if (current.getNext() == null){
                return namesAndDurations;
            }

            current = current.getNext();
        }

        return namesAndDurations;
    }

    @Override
    public String SongsInPlaylist(PlaylistArrayList playlist){
        String allSongs = "";

        if (front == null){
            throw new NoSuchElementException("Collection is empty");
        }

        PlaylistLinkedNode<PlaylistArrayList> current = front;
        while (current != null){
            if (current.getItem().equals(playlist)){
                allSongs += current.getItem().allSongs();
            }

            if (current.getNext() == null) {
                return allSongs;
            }

            current = current.getNext();
        }

        return allSongs;
    }
    @Override
    public void removePlaylist(PlaylistArrayList playlist_to_remove){

        if (front == null){
            throw new NoSuchElementException("Collection is empty");
        }

        PlaylistLinkedNode<PlaylistArrayList> current = front;
        PlaylistLinkedNode<PlaylistArrayList> removeCurrent = current;
        while (current != null){
            if (current.getNext().getItem().equals(playlist_to_remove)){
                if (current.getNext().getNext() != null){
                    PlaylistLinkedNode<PlaylistArrayList> remove = current.getNext();
                    current.setNext(current.getNext().getNext());
                    return;
                } else {
                    current.setNext(null);
                }

            }

        }





    }

    @Override
    public void addPlaylist(PlaylistLinkedNode playlist){

        if (front == null){
            front = playlist;
        }
        else {
            PlaylistLinkedNode<PlaylistArrayList> current = front;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(playlist);
        }
    }

    @Override
    public void removeSongFromAll(Song song){
        if (front == null){
            throw new NoSuchElementException("Collection is empty");
        }

        PlaylistLinkedNode<PlaylistArrayList> current = front;
        while (current != null){
            current.getItem().removeSong(song);
            current = current.getNext();
        }
    }

    @Override
    public int makeRandomPlaylistCollectionOfLength(List<Song> library, String name, int duration){
        int currentDuration = 0;
        Random random = new Random();

        int size = library.size();
        int min = 0;
        int max = size;

        for (int i = 0; i <= size; i++){
            int randNum = random.nextInt((max - min) + 1);

            Song currentSong = (Song) library.get(randNum);
            if (currentDuration + currentSong.getDuration() <= duration){
                currentDuration += currentSong.getDuration();
                //add to playlist
            } else {
                return currentDuration;
            }

        }

        return currentDuration;
       
    }
}