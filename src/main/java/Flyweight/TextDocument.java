package Flyweight;

import java.util.ArrayList;
import java.util.List;

public class TextDocument {
    private final List<TextCharacter> characters = new ArrayList<>();
    private final CharacterFactory factory = new CharacterFactory();

    public void addCharacter(char character, String font, int size, String color) {

    }

    public List<TextCharacter> getCharacters() {
        return List.copyOf(characters);
    }

    public void editCharacter(int index, char character, String font, int size, String color) {
    }

    public void display(){

    }

    public void saveFile(String filename){
    }

    public void loadFile(String filename){
    }

}
