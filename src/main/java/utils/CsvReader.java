package utils;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@UtilityClass
public class CsvReader {

    public static <T> List<T> readDataToBean(Class<? extends T> clazz, String path) throws FileNotFoundException {
        return new CsvToBeanBuilder<T>(new FileReader(path))
                .withType(clazz)
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build()
                .parse();
    }

}
