package lesson11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionStream {
    private Logger logger = LoggerFactory.getLogger(CollectionStream.class);
    public List<UUID> generateListUuid() {
        logger.info("created a collection of 10,000 items UUID");
        return Stream.generate(UUID::randomUUID).limit(10000).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CollectionStream collectionStream = new CollectionStream();
        collectionStream.generateListUuid();
        collectionStream.generateListUuid().forEach(System.out::println);
    }
}

