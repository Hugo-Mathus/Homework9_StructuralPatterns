package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;


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

    @Test
    void testDisplay(){
        TextDocument document = new TextDocument();
        document.addCharacter('H', "Arial", 12, "Red");
        document.addCharacter('e', "Arial", 12, "Red");
        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        java.io.PrintStream original = System.out;
        try {
            System.setOut(new java.io.PrintStream(output));
            document.display();
        } finally {
            System.setOut(original);
        }
        String result = output.toString();
        System.out.println("ACTUAL OUTPUT:");
        System.out.println(result);
        assertTrue(result.contains("Character: H | Font: Arial | Size: 12 | Color: Red"));
        assertTrue(result.contains("Character: e | Font: Arial | Size: 12 | Color: Red"));
    }

    @Test
    void testSaveFile() {
        TextDocument document = new TextDocument();

        document.addCharacter('H', "Arial", 12, "Red");
        document.addCharacter('e', "Calibri", 14, "Blue");

        File file = new File("testDocument.txt");

        // Make sure the file does not already exist
        if (file.exists()) {
            assertTrue(file.delete());
        }

        document.saveFile("testDocument.txt");

        // Check that the file was created
        assertTrue(file.exists());

        // Clean up after testing
        assertTrue(file.delete());
    }

}