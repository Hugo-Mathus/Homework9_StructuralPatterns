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

    @Test
    void testSharedCharacterProperties() {
        TextDocument document = new TextDocument();

        document.addCharacter('H', "Arial", 12, "Red");
        document.addCharacter('e', "Arial", 12, "Red");

        CharacterStyle style1 = document.getCharacters().get(0).getProperties();
        CharacterStyle style2 = document.getCharacters().get(1).getProperties();

        assertSame(style1, style2);
    }

    @Test
    void testEditCharacter() {
        TextDocument document = new TextDocument();
        document.addCharacter('H', "Arial", 12, "Red");
        document.addCharacter('e', "Arial", 12, "Red");
        document.editCharacter(1,'a', "Calibri", 11, "Blue");

        assertEquals('a', document.getCharacters().get(1).getCharacter());

        assertNotSame(document.getCharacters().get(0).getProperties(), document.getCharacters().get(1).getProperties());
    }
}