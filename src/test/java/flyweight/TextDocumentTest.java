package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextDocumentTest {

    @Test
    void testAddCharacter() {
        TextDocument document = new TextDocument();

        document.addCharacter('H', "Arial", 12, "Red");

        assertEquals(1, document.getCharacters().size());
        assertEquals('H', document.getCharacters().get(0).getCharacter());
    }
}