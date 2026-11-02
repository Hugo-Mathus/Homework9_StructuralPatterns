package Flyweight;

public class CharacterProperties implements CharacterStyle {
    private final String font;
    private final int size;
    private final String color;


    public CharacterProperties(String font, int size, String color){
            this.font = font;
            this.size = size;
            this.color = color;
    }

    public String getFont() {
        return font;
    }
    public int getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }

    @Override
    public void display(char character) {
        System.out.println("Character: " + character + " | Font: " + font + " | Size: " + size + " | Color: " + color);
    }
}
