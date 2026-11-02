package Flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
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

                writer.write(character.getCharacter() + "," + properties.getFont() + "," +properties.getSize() +"," + properties.getColor());
                writer.newLine();
            }
        }
        catch(IOException e){
            throw  new RuntimeException("Error saving file",e);
        }
    }

    public void loadFile(String filename){
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            characters.clear();
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",",-1);
                if (data.length != 4){
                    throw new IllegalArgumentException("Invalid data format");
                }

                char character = data[0].charAt(0);
                String font =  data[1];
                int size = Integer.parseInt(data[2]);
                String color = data[3];

                addCharacter(character,font,size,color);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading document",e);
        }
    }

}
