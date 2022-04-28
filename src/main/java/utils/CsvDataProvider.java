package utils;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class CsvDataProvider {
    //обобщить
    @DataProvider(name = "dataProvider", parallel = true)
    public static Object[] createData(Method method) throws FileNotFoundException {
        return CsvReader.readDataToBean(getClazz(method), getPath(method)).toArray();
    }

    private static String getPath(Method method){
        return method.getAnnotation(CSV.class).path();
    }

    private static Class<?> getClazz(Method method){
        return method.getAnnotation(CSV.class).clazz();
    }

}
