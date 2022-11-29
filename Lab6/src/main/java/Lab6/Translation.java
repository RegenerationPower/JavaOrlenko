package Lab6;

import java.util.HashMap;
import java.util.Scanner;

public class Translation {
    HashMap<String, String> dictionary;
    public Translation(){
        dictionary = new HashMap<>();
    }
    public void add(String word, String translation){
        dictionary.put(word, translation);
    }
    public void addWord(Scanner scanner){
        System.out.print("Enter word: ");
        String word = scanner.nextLine();
        System.out.print("Enter translation: ");
        String translation = scanner.nextLine();
        this.add(word, translation);
    }
    public String translate(String phrase) throws Exception{
        String[] words = phrase.trim().split("[\\s,.:;]+");
        String[] punctuation = phrase.split("[a-zA-z]+");
        StringBuilder translation = new StringBuilder();
        if (words.length==1){
            System.out.println("Enter phrase not a simple word");
        }
        else {
            for(int i = 0; i < words.length; ++i){
                if(dictionary.containsKey(words[i])){
                    translation.append(punctuation[i]).append(dictionary.get(words[i]));
                }
                else {
                    throw new Exception("[Error] - Your phrase contains unknown words: ");
                }
            }
        }
        return translation.toString();
    }
}
