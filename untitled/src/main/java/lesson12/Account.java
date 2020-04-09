package lesson12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

import static java.lang.System.out;

public class Account implements Runnable {
    private Logger logger = LoggerFactory.getLogger(Account.class);
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void run() {
        IntStream.range(0, 5).forEach(x -> {
            makeWithdrawal(10);
            if (getBalance() < 0) {
                logger.info("account is overdrawn!");
            }
        });
    }

    private void makeWithdrawal(int amount) {  //решаем проблему с гонками путем синхронизации этого метода
        if (getBalance() >= amount) {
            out.println(Thread.currentThread().getName()
                    + " is going to withdraw");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            withdraw(amount);
            logger.info(Thread.currentThread().getName()
                    + " completes the withdrawal. The balance is "
                    + getBalance());
        } else {
            logger.info("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw " + getBalance());
        }
    }
}