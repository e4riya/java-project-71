package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DiffEntry {
    private String key;
    private Object oldValue;
    private Object newValue;
    private KeyStatus status;
}
