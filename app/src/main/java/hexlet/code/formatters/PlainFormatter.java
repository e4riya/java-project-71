package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.ArrayList;

public class PlainFormatter implements CanFormat {
    @Override
    public String format(ArrayList<DiffEntry> diffs) {
        StringBuilder result = new StringBuilder();
        for (DiffEntry entry : diffs) {
            switch (entry.status()) {
                case STAYED:
                    break;
                case UPDATED:
                    result.append(
                        "Property \'" + entry.key() + "\' was updated. From " + getValue(entry.oldValue())
                            + " to " + getValue(entry.newValue()) + "\n");
                    break;
                case DELETED:
                    result.append("Property \'" + entry.key() + "\' was removed" + "\n");
                    break;
                case CREATED:
                    result.append(
                        "Property \'" + entry.key() + "\' was added with value: " + getValue(entry.newValue())
                            + "\n");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + entry.status());
            }
        }
        return result.toString().trim();
    }

    private String getValue(Object value) {
        if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value != null) {
            return "[complex value]";
        } else {
            return "null";
        }
    }
}
