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

@SuppressWarnings("MismatchedReadAndWriteOfArray")
public class Main {
    static PrintingImpl printingImpl = new PrintingImpl();
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
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
            Arrays.stream(result).forEach(System.out::println);
            printingImpl.printing("Lab finished");
        }
        System.out.println("Execution time + your input time: " + calculateTime(startTime) + "ms");
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
            Printing printing1 = printed -> "English words: " + printed;
            System.out.println(printing1.printing(String.valueOf(englishWords)));
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
    public static long calculateTime(long startTime) {
        Subtraction<Long> subtraction1 = Main::subtraction;
        return subtraction1.subtraction(System.currentTimeMillis(), startTime);
    }

    private static long subtraction(Long a, Long b) {
        return a - b;
    }
}