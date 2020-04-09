package lesson12.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class SmsService {
    private Logger logger = LoggerFactory.getLogger(SmsService.class);
    static List<Sms> smsList = new CopyOnWriteArrayList();
    static int size = 25;

    public void add() {
        if (smsList.size() < size) {
            smsList.add(new Sms());
            logger.info("Добавлено смс " + smsList.toString());
        } else {
            logger.info("Нет смс");
        }
    }

    public void delete() {
        if (smsList.size() > 0) {
            smsList.remove(0);
            logger.info("Удалено смс " + smsList.toString());
        } else {
            logger.info("Нет смс");
        }
    }

    public void update() {
        if (smsList.size() > 0) {
            int randomIndex = new Random().nextInt(smsList.size());
            Sms sms = smsList.get(randomIndex);
            sms.setContent(sms.getContent() + " update sms");
            smsList.set(randomIndex, sms);
            logger.info("Изменено смс " + smsList.toString());
        } else {
            logger.info("Нет смс");
        }
    }
}