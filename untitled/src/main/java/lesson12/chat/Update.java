package lesson12.chat;

public class Update implements Runnable {
    SmsService smsService = new SmsService();

    @Override
    public void run() {
        smsService.update();
    }
}
