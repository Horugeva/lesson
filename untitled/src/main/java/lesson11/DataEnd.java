package lesson11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataEnd {

    public void dataEnd() {
        Logger logger = LoggerFactory.getLogger(DataEnd.class);
        FileService fileService = new FileService();
        long start = fileService.fileReader();
        String str = String.valueOf(start);
        int n = Integer.parseInt(str.substring(0, 2));
        String m = str.substring(2);
        if (m.length() < 2) {
            m = ("0" + m);
        }
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime dataEnd = zonedDateTime.plusMonths(n).plusDays(Long.parseLong(m));
        logger.info("Count = " + start);
        logger.info("plus Mounts = " + n);
        logger.info("plus Days = " + m);
        logger.info("Data End = " + dataEnd);
    }

    public static void main(String[] args){
        DataEnd dataEnd = new DataEnd();
        dataEnd.dataEnd();
    }
}
