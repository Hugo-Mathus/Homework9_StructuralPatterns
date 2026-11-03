package Proxy;

import java.util.Map;
import java.util.List;
import java.util.HashMap;



public class SongServiceProxy implements SongService{
    private final SongService realService;
    private final Map<Integer,Song> idCache = new HashMap<>();
    private final Map<String,List<Song>> titleCache = new HashMap<>();
    private final Map<String,List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer SongID) {
        if (idCache.containsKey(SongID)) {
            return idCache.get(SongID);
        }
        Song song = realService.searchById(SongID);
        idCache.put(SongID,song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (titleCache.containsKey(title)) {
            return titleCache.get(title);
        }
        List<Song> results = realService.searchByTitle(title);
        titleCache.put(title,results);
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (albumCache.containsKey(album)) {
            return albumCache.get(album);
        }
        List<Song> results = realService.searchByAlbum(album);
        albumCache.put(album,results);
        return results;
    }
}
