package Proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

        Song result = proxy.searchById(5);
        assertNotNull(result);
        assertEquals("Gil", result.getTitle());
        assertEquals("Milo J", result.getArtist());
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

}
