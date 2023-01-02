package Laba8;
/*
Обчислення наближеного значення числа Пі методом Монте-Карло
У цьому завданні вам належить написати паралельну програму, яка обчислює значення числа Пі. Метод обчислення дуже простий:
•	Площа квадрата одиничної довжини дорівнює 1
•	Площа сектора 90 ° для одиничного кола: π/4
•	«Кидаємо» величезну кількість випадкових точок в одиничний квадрат
•	Рахуємо кількість точок, що потрапили в межі кола, тобто відстань від яких до (0,0) менше або дорівнює 1
•	Частка точок, які потрапили в коло дорівнює наближеному значенню π/4
Деталі реалізації
Ваше завдання написати паралельну реалізацію (ParallelMonteCarloPi.java). При написанні програми дотримуйтесь інструкцій:
• Першим і єдиним вхідним аргументом програми є кількість потоків
• В результаті програма виводить наступні дані:
PI is 3.14221
THREADS 8
ITERATIONS 1,000,000,000
TIME 12.83ms
 */

public class Main {
    public static void main(String[] args) {
        int threads = 4;
        int iterations = (int) 1e9;
        Calculations calculations = new Calculations(threads, iterations);
        double pi;
        long startTime = System.currentTimeMillis();
        try {
            pi = ParallelMonteCarloPi.calculatePi(calculations);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("PI is " + pi);
        System.out.println("THREADS " + threads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("TIME " + executionTime + "ms");
    }
}