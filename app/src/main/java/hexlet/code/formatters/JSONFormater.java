package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffEntry;

import java.util.ArrayList;

public class JSONFormater implements CanFormat {
    @Override
    public String format(ArrayList<DiffEntry> diffs) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(diffs);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
