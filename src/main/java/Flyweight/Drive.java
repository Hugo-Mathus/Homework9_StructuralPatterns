package Flyweight;

public class Drive {
    public static void main(String[] args) {
        TextDocument document = new TextDocument();
        String text = "HelloWorldCS3560";

        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);

            if (i < 5){
                document.addCharacter(character, "Arial",12,"Red");
            }
            else if (i < 10){
                document.addCharacter(character, "Calibri",14,"Blue");
            }
            else if(i < 12){
                document.addCharacter(character, "Verdana",16,"Blac");
            }
            else{
                document.addCharacter(character, "Georgia",20,"Green");
            }
        }
        System.out.println("DOCUMENT: ");
        document.display();

        String filename = "Homework9.txt";
        document.saveFile(filename);
        System.out.println("\nSaved document to: " + filename);

        TextDocument loadedDocument = new TextDocument();
        loadedDocument.loadFile(filename);

        System.out.println("Loaded document: ");
        loadedDocument.display();

        StringBuilder loadedText = new StringBuilder();

        for (TextCharacter character : loadedDocument.getCharacters()){
            loadedText.append(character.toString());
        }
        System.out.println("\nloaded text: " + loadedText);
    }
}
