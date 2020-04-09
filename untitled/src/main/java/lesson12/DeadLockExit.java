package lesson12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadLockExit {
    private Logger logger = LoggerFactory.getLogger(DeadLockExit.class);

    private static class Resource {
    }

    private final DeadLockExit.Resource buckwheat = new DeadLockExit.Resource();
    private final DeadLockExit.Resource paper = new DeadLockExit.Resource();

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
        try {
            dasha.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dasha.start();

    }
}
