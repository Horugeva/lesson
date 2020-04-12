package lesson12.chat;

public class Reader implements Runnable {
    SmsService smsService = new SmsService();

    public void run() {
        smsService.delete();
    }
}
