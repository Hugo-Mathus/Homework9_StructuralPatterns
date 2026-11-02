package Proxy;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class SongServiceProxy implements SongService{
    private final SongService realService;
    private final Map<Integer,Song> idCache = new HashMap<>();
    private final Map<Integer,List<Song>> titleCache = new HashMap<>();
    private final Map<Integer,List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer SongID) {
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return null;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return null;
    }
}
