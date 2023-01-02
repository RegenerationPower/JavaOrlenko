package Laba8;

public class Calculations {
    private final int threads;
    private final int iterations;

    public Calculations(int threads, int iterations) {
        this.threads = threads;
        this.iterations = iterations;
    }

    public int getCountOfIterations() {
        return iterations / threads;
    }

    public int getTotalThreads() {
        return threads;
    }

    public int getTotalIterations() {
        return iterations;
    }
}
