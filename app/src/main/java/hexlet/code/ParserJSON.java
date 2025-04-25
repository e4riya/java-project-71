package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class ParserJSON {
    public static Map<String,Object> getData(String content) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(new File(content), Map.class);
        return map;
    }
}
