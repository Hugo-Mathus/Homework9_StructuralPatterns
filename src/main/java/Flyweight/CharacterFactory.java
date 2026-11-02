package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<String, CharacterStyle> styles = new HashMap<>();
    public CharacterStyle getCharacterProperties(String font, int size, String color){
        String key = font + "|" +  size + "|" + color;
        if (styles.containsKey(key)) {
            return styles.get(key);
        }

        CharacterStyle newStyle = new CharacterProperties(font, size, color);
        styles.put(key, newStyle);
        return newStyle;
    }
}
