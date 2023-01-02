package Laba4;
/*
До виконання всі завдання
1.	Напишіть програму, яка отримає рядок з максимальною кількістю слів із заданого файлу.
2.	Відкрийте код додатка за завданням Task 3 Simple OOP і внесіть наступні зміни (хто виконав Task 3 Mid OOP ігнорує це завдання,
    але все ж ознайомлюється з теорією):
- додайте в меню команду для збереження набору об'єктів в файл;
- передбачте можливість читання набору об'єктів з файлу.
3.	Зашифрувати вхідний символьний потік за наступним алгоритмом: замінити кожний символ на такий, код якого більший на значення коду ключового символу.
    При виконанні завдання:
a.	Реалізувати метод, який реалізує шифрування
b.	Реалізувати метод, який реалізує дешифрування.
c.	Використати для розв’язання задачі потоки типу FilerOutputStream-FilterInputStream/FilterWriter-FilteredReader.
4.	Підрахувати частоту, з якою зустрічаються теги на сторінці по URL (URL на ваш вибір).
a.	Вивести результати наступним чином: в порядку зростання для тегів в лексикографічному порядку
b.	Вивести результати наступним чином: в порядку зростання по частоті появи тегів
ВИМОГИ
1.	Передбачте можливість введення розташування та ім’я файлу для збереження даних.
2.	Використовуйте об'єктні потоки для роботи з файлом.
3.	Застосуйте серіалізацію за замовчуванням для роботи з файлами.
4.	Виділіть роботу з файлами в окремий клас.
5.	Дані для пошуку інформації в наборі даних повинні вводитися набором з клавіатури.
6.	Передбачте обробку коректності введення даних через блоки try-catch.
 */

import Laba4.Encoding.Encoding;
import Laba4.Encoding.Decoding;
import Laba4.HtmlCounter.HtmlCounter;
import Laba4.WordsCounter.File;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    static boolean isSuccessful = false;
    public static void main(String[] args) {
        while (!isSuccessful) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Words Counter");
                System.out.println("Enter input file path: ");
                String fileInput = scanner.nextLine();

                if (fileInput.equals("")) {
                    fileInput = "in.txt";
                }

                File file = new File(fileInput);
                System.out.println("Longest line in " + fileInput + " has " + file.getMaxWordsInLine() + " words:\n"
                        + file.getMaxLine());
                file.close();
                System.out.println("Enter output file path: ");
                String fileOutput = scanner.nextLine();

                if (fileOutput.equals("")) {
                    fileOutput = "out.txt";
                }

                System.out.println("Encoding and Decoding");
                System.out.print("Enter key character: ");
                char keyCharacter = scanner.next().charAt(0);
                Encoding encoding = new Encoding(new FileInputStream(fileInput), keyCharacter);
                Decoding decoding = new Decoding(new FileOutputStream(fileOutput), keyCharacter);
                String encodingFile = Arrays.toString(fileOutput.split("\\..*$"))
                        .replaceAll("\\[", "").replaceAll("\\]", "") + "-encoded.txt";
                FileOutputStream encodingOutput = new FileOutputStream(encodingFile);
                int symbolNumber;
                while ((symbolNumber = encoding.read()) != -1) {
                    decoding.write(symbolNumber); //decode out
                    encodingOutput.write(symbolNumber); //encode out-encoded
                }
                encoding.close();
                decoding.close();
                encodingOutput.close();
                System.out.println("HTML counter");
                System.out.print("Enter URL: ");
                String invisibleScan = scanner.nextLine();
                String link = scanner.nextLine();
                if (link.equals("")) {
                    link = "https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0";
                }
                HtmlCounter htmlCounter = new HtmlCounter(link);
                String html = htmlCounter.getHtml();
                htmlCounter.close();
                ArrayList<String> content = new ArrayList<>(Arrays.asList(html.split("<")));
                ArrayList<String> tags = new ArrayList<>();
                HashMap<String, Integer> countElements = new HashMap<>();
                for (String fullTag : content) {
                    if (fullTag.length() > 0 && Character.isLetter(fullTag.charAt(0))) {
                        String tag = fullTag.split(" ")[0];
                        if (tag.contains(">")) {
                            tag = tag.substring(0, tag.indexOf(">")); //text inside the "<>"
                        }
                        tag = tag.replace("/", "");
                        if (!tag.matches("[a-zA-Z0-9]+")) { //fixing empty tag error
                            continue;
                        }
                        tags.add(tag);
                        if (countElements.containsKey(tag)) { //hashmap check presence
                            countElements.put(tag, countElements.get(tag) + 1);
                        } else {
                            countElements.put(tag, 1);
                        }
                    }
                }

                Collections.sort(tags);
                System.out.println("Sorted HTML tags:");
                System.out.println(tags);
                System.out.println("Sorted by frequency:");
                countElements.entrySet().stream().sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(HashMap.Entry.comparingByKey())).forEach(System.out::println);
                isSuccessful=true;

            } catch (NoSuchFileException e) {
                System.out.println("File not found: " + e.getMessage() + " Error");
            } catch (MalformedURLException e) {
                System.out.println("URL not found: " + e.getMessage() + " Error");
            } catch (IOException e) {
                System.out.println("General I/O exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unknown Error: " + e.getMessage());
            }

        }
    }
}