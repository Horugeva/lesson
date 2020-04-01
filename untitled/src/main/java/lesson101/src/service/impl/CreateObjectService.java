package lesson101.src.service.impl;

import lesson101.Data;
import lesson101.src.HumanEntity;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CreateObjectService {
    private FileService fileService = new FileService();

    public List<Object> createObjectReflection() throws IOException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<Data> dataList = fileService.getDataFromTxtFile("file.txt");
        List<Object> result = new ArrayList<>();
        for (Data data : dataList) {
            Object o = HumanEntity.class.getConstructor(String.class, int.class).newInstance(data.getName(), data.getAge());
            result.add(o);
        }
        return result;
    }
}
