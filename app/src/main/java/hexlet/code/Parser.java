package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, String> getData(String content) throws Exception {
        ObjectMapper mapper = null;
        if(content.endsWith(".json")) {
            mapper = new ObjectMapper(new JsonFactory());
        } else if (content.endsWith(".yml") || content.endsWith(".yaml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        }
        Map<String, Object> map = mapper.readValue(new File(content), Map.class);
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            result.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return result;
    }
}
