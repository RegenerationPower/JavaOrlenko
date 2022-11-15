package lab2;

/*
Виконав студент групи ІО-04 Возниця Дмитро
Номер у списку: 13
Завдання 2.1
Крок 1. Реалізувати метод equals для класу Person у якого є декілька полів.
Крок 2. Реалізуйте наступний сценарій:
a.	Створіть екземпляр Person
b.	Конвертуйте його в JSON*
c.	Конвертуйте назад в об’єкт*
d.	Перевірте equals-ом початковий і одержаний об'єкти
* Для серіалізації та десеріалізації в/з JSON можна використовувати бібліотеку gson (https://sites.google.com/site/gson/gson-user-guide).
Бажано!
Реалізуйте unit tests для методу equals за допомогою бібліотеки equals verifier
 */

import com.google.gson.Gson;

public class Main {
    static Person person1 = new Person("Dmytro", "Voznytsia", 19);
    static Person person2 = new Person("Robert", "Black", 43);
    static Person person3 = new Person("Dmytro", "Voznytsia", 19);
    static Person personJson = new Person("Fred", "Wave", 25);

    public static void main(String[] args) {
        System.out.println("The first person equal to the second: " + person1.equals(person2));
        System.out.println("The first person equal to the third: " + person1.equals(person3));
        System.out.println("The second person equal to the third: " + person2.equals(person3));

        Gson gson = new Gson();
        String json = gson.toJson(personJson);
        Person read = gson.fromJson(json, Person.class);
        System.out.println("The received object is similar to the original one: " + personJson.equals(read));
    }

}