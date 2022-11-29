package Lab6;
/*
Напишіть консольний додаток, який:
-	описує клас, який є перекладачем з англійської мови та містить словник англійських та українських слів у вигляді колекції HashMap <String, String>,
    метод для додавання пар слів та метод для перекладу отриманої фрази;
-	створює екземпляр описаного класу, наповнює словник (також підтримує введення даних з клавіатури);
-	вводить деяку фразу англійською мовою та відображає її переклад українською мовою.

 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translation translate = new Translation();
        translate.add("I", "я");
        translate.add("want", "хочу");
        translate.add("unlimited", "нескінченний");
        translate.add("electricity", "електрика");

        String answer = "yes";
        while(answer.equalsIgnoreCase("yes")){
            System.out.print("Add new word to a dictionary?(yes or Press any key): ");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("yes")){
                translate.addWord(scanner);
            }
        }
        try {
            System.out.print("Enter phrase to translate: ");
            String phrase = scanner.nextLine();
            System.out.println(translate.translate(phrase));
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}