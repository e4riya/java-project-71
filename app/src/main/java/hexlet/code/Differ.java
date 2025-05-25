package hexlet.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(Map<String, Object> first, Map<String, Object> second, String format) {
        Set<String> keys = new TreeSet<>(first.keySet());
        keys.addAll(second.keySet());
        ArrayList<DiffEntry> diffs = new ArrayList<>();
        for (String key : keys) {
            KeyStatus status;
            if (first.containsKey(key) && second.containsKey(key)) {
                if (Objects.equals(first.get(key), second.get(key))) {
                    status = KeyStatus.STAYED;
                } else {
                    status = KeyStatus.UPDATED;
                }
            } else if (first.containsKey(key) && !second.containsKey(key)) {
                status = KeyStatus.DELETED;
            } else {
                status = KeyStatus.CREATED;
            }
            diffs.add(new DiffEntry(
                key, first.get(key),
                second.get(key), status
            ));
        }
        return Formater.getFormatter(format).format(diffs);
    }
}
