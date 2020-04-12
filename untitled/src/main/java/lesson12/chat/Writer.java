package lesson12.chat;

public class Writer implements Runnable {
    SmsService smsService = new SmsService();

    @Override
    public void run() {
        smsService.add();
    }
}
