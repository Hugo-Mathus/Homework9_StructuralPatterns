package Proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    @Test
    void TestGetTitle() {
        Song song = new Song("Title", "Hugo", "Mathus", 120);
        assertEquals("Title",  song.getTitle());
    }

    @Test
    void TestGetArtist() {
        Song song = new Song("Title", "Hugo", "Mathus", 120);
        assertEquals("Hugo", song.getArtist());
    }

    @Test
    void TestGetAlbum() {
        Song song = new Song("Title", "Hugo", "Mathus", 120);
        assertEquals("Mathus", song.getAlbum());
    }

    @Test
    void TestGetDuration() {
        Song song = new Song("Title", "Hugo", "Mathus", 120);
        assertEquals(120, song.getDuration());
    }
}
