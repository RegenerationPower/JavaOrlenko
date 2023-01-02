package Laba8;

import java.util.Random;

public class ThreadsOperations extends Thread {
    final int countIterations;
    private int inCircle;

    public ThreadsOperations(int countOfIterations) {
        this.countIterations = countOfIterations;
    }

    @Override
    public void run() {
        Random random = new Random();
        inCircle = 0;
        double x, y;
        for (int i = 0; i < countIterations; ++i) {
            x = random.nextDouble();
            y = random.nextDouble();
            if ((x * x + y * y) <= 1) {
                ++inCircle;
            }
        }
    }

    public int getPassed() {
        return inCircle;
    }
}
