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
}
