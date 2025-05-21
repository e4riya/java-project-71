package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.ArrayList;

public class PlainFormatter implements CanFormat {
    @Override
    public String format(ArrayList<DiffEntry> diffs) {
        StringBuilder result = new StringBuilder();
        for (DiffEntry entry : diffs) {
            switch (entry.getStatus()) {
                case STAYED:
                    break;
                case UPDATED:
                    result.append(
                        "Property \'" + entry.getKey() + "\' was updated. From " + getValue(entry.getOldValue())
                            + " to " + getValue(entry.getNewValue()) + "\n");
                    break;
                case DELETED:
                    result.append("Property \'" + entry.getKey() + "\' was removed" + "\n");
                    break;
                case CREATED:
                    result.append(
                        "Property \'" + entry.getKey() + "\' was added with value: " + getValue(entry.getNewValue())
                            + "\n");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + entry.getStatus());
            }
        }
        return result.toString().trim();
    }

    private String getValue(Object value) {
        if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof String) {
            return value.toString().equals("null") ? "null" : "'" + value.toString() + "'";
        } else {
            return "[complex value]";
        }
    }
}
