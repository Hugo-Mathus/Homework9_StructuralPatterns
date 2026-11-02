package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextCharacterTest {

    @Test
    public void testGetCharacter() {
        CharacterStyle style = new CharacterProperties("Arial" , 12 , "Red");
        TextCharacter character = new TextCharacter('a', style);
        assertEquals('a', character.getCharacter());
    }

    @Test
    public void testGetProperties() {
        CharacterStyle style = new CharacterProperties("Arial" , 12 , "Red");
        TextCharacter character = new TextCharacter('a', style);

        assertSame(style, character.getProperties());

    }
}
