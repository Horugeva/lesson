package lesson12.chat;

import java.util.Random;

public class Sms {
    String content;

    public Sms() {
        Random random = new Random();
        char[] content = new char[random.nextInt(8) + 3];
        for (int j = 0; j < content.length; j++) {
            content[j] = (char) ('a' + random.nextInt(26));
        }
        this.content = new String(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "sms='" + content + '\'' +
                '}';
    }
}
