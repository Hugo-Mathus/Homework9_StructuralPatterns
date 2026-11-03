package Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RealSongService implements SongService {
    private final Map<Integer, Song> songs = new HashMap<>();
    public RealSongService() {
        songs.put(1, new Song("Kiss of Life", "Sade", "The Best of Sade", 251));
        songs.put(2, new Song("About A Girl - Live", "Nirvana", "MTV Unplugged In New York", 218));
        songs.put(3, new Song("Time", "Pink Floyd", "The Dark Side of The Moon", 402));
        songs.put(4, new Song("#1 Crush", "Garbage", "Absolute Garbage", 345));
        songs.put(5, new Song("Gil", "Milo J", "La Vida Era Mas Corta", 234));
        songs.put(6, new Song("RAIN III", "Trueno", "EL ULTIMO BAILE", 209));
        songs.put(7, new Song("Recorde", "Milo J", "La Vida Era Mas Corta", 180));
    }
    @Override
    public Song searchById(Integer id) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return songs.get(id);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        List<Song> results = new ArrayList<>();
        for (Song song : songs.values()) {
            if (song.getTitle().equals(title)) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        List<Song> results = new ArrayList<>();
        for (Song song : songs.values()) {
            if (song.getAlbum().equals(album)) {
                results.add(song);
            }
        }
        return results;
    }
}
