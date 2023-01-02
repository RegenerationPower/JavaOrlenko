package Laba8;

public class ParallelMonteCarloPi {
    public static double calculatePi(Calculations calculations) throws InterruptedException {
        int totalThreads = calculations.getTotalThreads();
        int totalIterations = calculations.getTotalIterations();
        int countOfIterations = calculations.getCountOfIterations();
        ThreadsOperations[] threads = new ThreadsOperations[totalThreads];
        for(int i = 0; i < totalThreads; ++i){
            threads[i] = new ThreadsOperations(countOfIterations);
            threads[i].start();
        }
        int totalPassed = 0;
        for(ThreadsOperations thread: threads){
            thread.join();
            totalPassed += thread.getPassed();
        }
        return 4.0 * totalPassed / totalIterations;
    }
}
