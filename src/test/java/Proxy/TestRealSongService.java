package Proxy;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRealSongService {

    @Test
    public void testSearchByID() {
        RealSongService realSongService = new RealSongService();
        Song result = realSongService.searchById(1);
        assertNotNull(result);
        assertEquals("Kiss of Life", result.getTitle());
    }

    @Test
    public void testSearchByTitle() {
        RealSongService realSongService = new RealSongService();
        List<Song> results = realSongService.searchByTitle("Kiss of Life");
        assertNotNull(results);
        assertTrue(results.isEmpty());
    }

    @Test
    public void testSearchByAlbum() {
        RealSongService realSongService = new RealSongService();
        List<Song> results = realSongService.searchByAlbum("La Vida Era Mas Corta");
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals("Time", results.get(0).getTitle());

        assertTrue(results.stream().anyMatch(song -> song.getTitle().equals("Gil")));
        assertTrue(results.stream().anyMatch(song -> song.getTitle().equals("Recorde")));
    }
}
