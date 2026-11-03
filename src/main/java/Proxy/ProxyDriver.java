package Proxy;
import java.util.List;

public class ProxyDriver {
    public static void main(String[] args) {
        SongService realService = new RealSongService();
        SongService proxy = new SongServiceProxy(realService);

        System.out.println("Music Streaming Service: ");
        System.out.println("Search By ID");
        long start = System.nanoTime();
        Song song = proxy.searchById(5);
        long firstTime = System.nanoTime() - start;

        if(song != null){
            System.out.println("Found: " + song.getTitle() + " - " + song.getArtist());
        }
        System.out.println("First Search took: " + firstTime / 1_000_000.0 + " ms");

        start = System.nanoTime();
        Song cachedsong = proxy.searchById(5);
        long cachedTime = System.nanoTime() - start;
        System.out.println("Cached search: " + cachedTime / 1_000_000.0 + " ms");

        // Search by title
        System.out.println("\nSearch By Title");

        start = System.nanoTime();
        List<Song> titleResults = proxy.searchByTitle("Time");
        firstTime = System.nanoTime() - start;

        for (Song result : titleResults) {
            System.out.println("Found: " + result.getTitle()
                    + " - " + result.getArtist());
        }

        System.out.println("First search: " + firstTime / 1_000_000.0 + " ms");

        start = System.nanoTime();
        List<Song> cachedTitles = proxy.searchByTitle("Time");
        cachedTime = System.nanoTime() - start;

        System.out.println("Cached search: " + cachedTime / 1_000_000.0 + " ms");

        // Search by album
        System.out.println("\nSearch By album");

        start = System.nanoTime();
        List<Song> albumResults =
                proxy.searchByAlbum("La Vida Era Mas Corta");
        firstTime = System.nanoTime() - start;

        for (Song result : albumResults) {
            System.out.println("Found: " + result.getTitle()
                    + " - " + result.getArtist());
        }

        System.out.println("First search: " + firstTime / 1_000_000.0 + " ms");

        start = System.nanoTime();
        List<Song> cachedAlbums =
                proxy.searchByAlbum("La Vida Era Mas Corta");
        cachedTime = System.nanoTime() - start;

        System.out.println("Cached search: " + cachedTime / 1_000_000.0 + " ms");
    }

}

