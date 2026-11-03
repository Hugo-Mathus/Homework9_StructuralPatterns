package Proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SongServiceProxyTest {
    @Test
    public void testSearchById() {
        RealSongService realService = new RealSongService();
        SongService proxy = new SongServiceProxy(realService);

        Song result = proxy.searchById(5);
        assertNotNull(result);
        assertEquals("Gil", result.getTitle());
        assertEquals("Milo J", result.getArtist());
    }

    @Test
    public void testSearchByTitle() {
        RealSongService realService = new RealSongService();
        SongService proxy = new SongServiceProxy(realService);

        List<Song> results = proxy.searchByTitle("Time");
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Time", results.get(0).getTitle());
        assertEquals("Pink Floyd", results.get(0).getArtist());

    }

    @Test
    void testSearchByTitleCaching() {
        SongService proxy = new SongServiceProxy(new RealSongService());

        List<Song> first = proxy.searchByTitle("Time");
        List<Song> second = proxy.searchByTitle("Time");

        assertNotNull(first);
        assertEquals(1, first.size());
        assertSame(first, second);
    }

    @Test
    void testSearchByIdCaching() {
        SongService realService = new RealSongService();
        SongService proxy = new SongServiceProxy(realService);

        long start = System.nanoTime();
        Song first = proxy.searchById(5);
        long firstDuration = System.nanoTime() - start;

        start = System.nanoTime();
        Song second = proxy.searchById(5);
        long secondDuration = System.nanoTime() - start;

        assertNotNull(first);
        assertSame(first, second);
        assertTrue(secondDuration < firstDuration);
    }

    @Test
    void testSearchByAlbum() {
        SongService proxy = new SongServiceProxy(new RealSongService());

        List<Song> results =
                proxy.searchByAlbum("La Vida Era Mas Corta");

        assertNotNull(results);
        assertEquals(2, results.size());

        assertTrue(results.stream()
                .anyMatch(song -> song.getTitle().equals("Gil")));

        assertTrue(results.stream()
                .anyMatch(song -> song.getTitle().equals("Recorde")));
    }

}
