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
}
