package lesson12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadlockRisk implements Runnable {
    private Logger logger = LoggerFactory.getLogger(DeadlockRisk.class);

    private static class Resource {
    }

    private final Resource buckwheat = new Resource();
    private final Resource paper = new Resource();

    public void goHome() {
        synchronized (buckwheat) {
            logger.info(Thread.currentThread().getName()
                    + " взяла гречку для самоизоляции");
            synchronized (paper) {
                logger.info(Thread.currentThread().getName()
                        + " взяла бумагу для самоизоляции");
                logger.info(Thread.currentThread().getName()
                        + " идет домой");
            }
        }
    }

    public void sitAtHome() {
        synchronized (paper) {
            logger.info(Thread.currentThread().getName()
                    + " запаслась бумагой и сидит дома");
            synchronized (buckwheat) {
                logger.info(Thread.currentThread().getName()
                        + " запаслась гречкой и сидит дома");
                logger.info(Thread.currentThread().getName()
                        + " молодец");
            }
        }
    }

    public void run() {
        goHome();
        sitAtHome();
    }

    public static void main(String[] args) {
        DeadlockRisk job = new DeadlockRisk();
        Thread masha = new Thread(job, "Маша");
        Thread dasha = new Thread(job, "Даша");
        masha.start();
        dasha.start();

    }
}
