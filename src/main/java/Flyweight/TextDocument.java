package Flyweight;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class TextDocument {
    private final List<TextCharacter> characters = new ArrayList<>();
    private final CharacterFactory factory = new CharacterFactory();

    public void addCharacter(char character, String font, int size, String color) {
        CharacterStyle style = factory.getCharacterProperties(font,size,color);
        TextCharacter newCharacter = new TextCharacter(character, style);

        characters.add(newCharacter);
    }

    public List<TextCharacter> getCharacters() {
        return List.copyOf(characters);
    }

    public void editCharacter(int index, char character, String font, int size, String color) {
        CharacterStyle style = factory.getCharacterProperties(font,size,color);
        TextCharacter newCharacter = new TextCharacter(character, style);
        characters.set(index, newCharacter);
    }

    public void display(){
        for (TextCharacter character : characters){
            character.display();
        }
    }

    public void saveFile(String filename){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (TextCharacter character : characters){
                CharacterProperties properties = (CharacterProperties) character.getProperties();

                writer.write((int) character.getCharacter() + "," + properties.getFont() + "," +properties.getSize() +"," + properties.getColor());
                writer.newLine();
            }
        }
        catch(IOException e){
            throw  new RuntimeException("Error saving file",e);
        }
    }

    public void loadFile(String filename){
    }

}
