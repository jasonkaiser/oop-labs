package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SongIterator implements Iterator<Song> {


    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex = 0;


    public SongIterator(List<Song> playlist,String targetGenre){
        this.playlist = playlist;
        this.targetGenre = targetGenre;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < playlist.size()){
            if(playlist.get(currentIndex).getGenre().equals(targetGenre)){
                return true;
            }

            currentIndex++;
        }

        return false;
    }

    @Override
    public Song next() {

        if(!hasNext()){
            throw new NoSuchElementException("No more songs available");
        }
        return playlist.get(currentIndex++);
    }
}

class PlayLists{

    public static void main(String[] args) {

        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Song1", "Pop", "Test"));
        playlist.add(new Song("Song2", "Rock", "Test"));
        playlist.add(new Song("Song3", "Jazz", "Test"));
        playlist.add(new Song("Song4", "Pop", "Test"));

        SongIterator genreIterator = new SongIterator(playlist, "Jazz");

        while(genreIterator.hasNext()){

            System.out.println(genreIterator.next());
        }

    }
}