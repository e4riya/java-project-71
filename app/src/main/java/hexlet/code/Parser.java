package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper(new JsonFactory());
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    public static Map<String, Object> getData(String content) throws IllegalArgumentException, IOException {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }

        try {
            if (content.trim().startsWith("{")) {
                return JSON_MAPPER.readValue(content, Map.class);
            } else {
                return YAML_MAPPER.readValue(content, Map.class);
            }
        } catch (IOException e) {
            throw new IOException("Failed to parse content. Ensure it's valid JSON or YAML", e);
        }
    }
}
