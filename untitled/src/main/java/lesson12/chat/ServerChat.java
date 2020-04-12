package lesson12.chat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ServerChat {
    static int N = 2;
    static int M = 2;
    static int K = 1;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            startWriter(N);
            startUpdater(M);
            startReader(K);
        }
    }

    private static void startWriter(int N) throws InterruptedException {
        Writer writer = new Writer();
        ExecutorService executorService = Executors.newFixedThreadPool(N);
        IntStream.range(0, N).mapToObj(i -> writer).forEach(executorService::submit);
        Thread.sleep(2000 + (long) (Math.random() * 6000));

    }

    private static void startReader(int M) throws InterruptedException {
        Reader reader = new Reader();
        ExecutorService executorService = Executors.newFixedThreadPool(M);
        IntStream.range(0, M).mapToObj(i -> reader).forEach(executorService::submit);
        Thread.sleep(3000 + (long) (Math.random() * 5000));
    }

    private static void startUpdater(int K) throws InterruptedException {
        Update update = new Update();
        ExecutorService executorService = Executors.newFixedThreadPool(K);
        IntStream.range(0, K).mapToObj(i -> update).forEach(executorService::submit);
        Thread.sleep(4000);
    }
}

