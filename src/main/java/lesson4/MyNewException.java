package lesson4;
//Создать собственные исключения
//Использовать try, catch, throw, throws
//Отдельные логгеры для сервиса, репозитория, конвертера
//Один из них должен писать в консоль, второй в файл, третий и в консоль и в файл
//Использовать разные аппендеры для разных логгеров
//Использовать slf4j + logback.xml

public class MyNewException extends Exception {
    public MyNewException(String message) {
        super(message);
    }

    public MyNewException() throws MyNewException {
        throw new MyNewException("MyNewException");
    }
}