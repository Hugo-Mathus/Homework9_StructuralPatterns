package Proxy;

import java.util.List;

public interface SongService {
    Song searchById(int SongID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);

}
