package Flyweight;

public class TextCharacter {
    private char character;
    private CharacterStyle properties;

    public TextCharacter(char character, CharacterStyle properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterStyle getProperties() {
        return properties;
    }

    public void display() {
        properties.display(character);
    }
}
