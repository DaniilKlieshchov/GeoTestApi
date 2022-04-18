package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class PojoMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> convertToMap(Object pojo){
        return mapper.convertValue(pojo, new TypeReference<>() {});
    }


}
