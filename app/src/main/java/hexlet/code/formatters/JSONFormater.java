package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffEntry;

import java.util.ArrayList;

/**
 * Formatter that outputs differences in JSON format.
 * Converts the list of differences to a JSON string representation.
 */
public class JSONFormater implements CanFormat {
    /**
     * Formats the differences in JSON format.
     * @param diffs List of differences between files
     * @return JSON string representing the differences
     * @throws RuntimeException if JSON processing fails
     */
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
