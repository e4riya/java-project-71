package hexlet.code;

public record DiffEntry(String key, Object oldValue, Object newValue, KeyStatus status) {
}
