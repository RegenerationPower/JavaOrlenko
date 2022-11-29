package org.lab4;
import org.lab4.Encoding.Encoding;
import org.lab4.Encoding.Decoding;
import org.lab4.HtmlCounter.HtmlCounter;
import org.lab4.WordsCounter.File;

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
                System.out.println("[TASK 4]");
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