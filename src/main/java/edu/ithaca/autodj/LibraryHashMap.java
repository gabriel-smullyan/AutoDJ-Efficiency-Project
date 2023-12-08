package edu.ithaca.autodj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import interfaces.Library;

public class LibraryHashMap implements Library<Song> {
    private HashMap<String, Song> songs;

    public LibraryHashMap() {
        songs = new HashMap<>();
    }

    @Override
    public void addSong(Song song) {
        songs.put(song.getTitle(), song);
    }

    @Override
    public void removeSong(String songTitle) {
        if (songs.get(songTitle) == null) {
            throw new IllegalArgumentException("Song not found");
        }
        songs.remove(songTitle);
    }

    @Override
    public Song getSong(String songTitle) {
        if (songs.get(songTitle) == null) {
            throw new IllegalArgumentException("Song not found");
        }
        return songs.get(songTitle);
    }

    @Override
    public void addAlbumOfSongs(ArrayList<Song> songs) {
        for (int i = 0; i < songs.size(); i++) {
            addSong(songs.get(i));
        }
    }

    @Override
    public void removeAlbumOfSongs(ArrayList<Song> songs) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i) == null) {
                throw new IllegalArgumentException("Song not found");
            }
            removeSong(songs.get(i).getTitle());
        }
    }

    @Override
    public String allSongsAlphabetical() {
        List<String> titles = new ArrayList<>(songs.keySet());
        Collections.sort(titles);
        StringBuilder allSongs = new StringBuilder();
        for (int i = 0; i < titles.size(); i++) {
            allSongs.append(songs.get(titles.get(i)).toString()).append("\n");
        }
        return allSongs.toString();
    }

    @Override
    public int getSize() {
        return songs.size();
    }





}
