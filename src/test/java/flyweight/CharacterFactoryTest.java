package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterFactoryTest {
    @Test
    public void testCreateCharacter() {
        CharacterFactory factory = new CharacterFactory();
        CharacterStyle style = factory.getCharacterProperties("Arial", 12, "Red");
        assertNotNull(style);
    }

    @Test
    public void testCreateCharacterStyle() {
        CharacterFactory factory = new CharacterFactory();

        CharacterStyle style1 = factory.getCharacterProperties("Arial", 12, "Red");
        CharacterStyle style2 = factory.getCharacterProperties("Arial", 12, "Red");

        assertNotNull(style1);
        assertSame(style1, style2);
    }
    @Test
    void testDifferentCharacterStyles() {
        CharacterFactory factory = new CharacterFactory();

        CharacterStyle style1 =
                factory.getCharacterProperties("Arial", 12, "Red");

        CharacterStyle style2 =
                factory.getCharacterProperties("Calibri", 14, "Blue");

        assertNotNull(style1);
        assertNotNull(style2);
        assertNotSame(style1, style2);
    }
}
