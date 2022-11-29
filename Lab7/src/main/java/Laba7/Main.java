package Laba7;
/*
    Author: ІО-04 Возниця Дмитро
    Number in the list: 13
    Variant: 3
    3.	Знайти ті слова, які містять тільки символи латинського алфавіту.
    Серед них знайти ті слова, які містять рівну кількість голосних та приголосних.
    На вхід поступає рядок із словами. На виході – масив String.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input your text: ");
        String text = in.nextLine();
        String[] noEqualResult = new String[]{""};
        String[] noEqualResultWithoutEnglishWords = new String[]{};
        String[] result = findEnglishWords(text);

        if (Arrays.equals(result, noEqualResult)) {
            System.out.println("There aren't any English words with equal number of vowels and consonants");
        }
        else if(Arrays.equals(result, noEqualResultWithoutEnglishWords)) {
            System.out.println("There aren't any words with equal number of vowels and consonants");
        }
        else {
            System.out.print("English words with equal number of vowels and consonants: \n");
            Arrays.stream(result).forEach(res -> System.out.println(res));
        }
    }

    public static String[] findEnglishWords(String text) {
        String[] words = text.split("\\b");
        StringBuilder englishWords = new StringBuilder();

        for (String word : words) {
            if (word.matches("[a-zA-Z]*")) {
                englishWords.append(word).append(" ");
            }
        }

        if (englishWords.toString().equals("")) {
            System.out.println("There aren't any English words");
        }
        else {
            System.out.println("English words: " + englishWords);
        }

        String[] englishWordsArr = englishWords.toString().split("\\s");
        StringBuilder resultStr = new StringBuilder();

        for (String word : englishWordsArr) {
            String[] letters = word.split("");
            int countVowels = 0;
            for (String letter : letters) {
                if (letter.matches("[aAeEiIoOuUyY]")) {
                    countVowels++;
                }
            }
            if (countVowels == (double)word.length()/2) {
                resultStr.append(word).append(" ");
            }
        }
        return resultStr.toString().split("\\s");
    }
}