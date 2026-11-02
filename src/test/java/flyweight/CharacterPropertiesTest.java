package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CharacterPropertiesTest {
    @Test
    public void testGetFont(){
        CharacterProperties properties = new CharacterProperties("Arial", 12, "Red");
        assertEquals("Arial", properties.getFont());
    }

    @Test
    public void testGetSize(){
        CharacterProperties properties = new CharacterProperties("Arial", 12, "Red");
        assertEquals(12, properties.getSize());
    }

    @Test
    public void testGetColor(){
        CharacterProperties properties = new CharacterProperties("Arial", 12, "Red");
        assertEquals("Red", properties.getColor());
    }
}
