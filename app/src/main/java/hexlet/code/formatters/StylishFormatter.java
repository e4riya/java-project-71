package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.ArrayList;

public class StylishFormatter implements CanFormat {
    @Override
    public String format(ArrayList<DiffEntry> diffs) {
        StringBuilder result = new StringBuilder();
        for (DiffEntry entry : diffs) {
            switch (entry.getStatus()) {
                case STAYED:
                    result.append("    " + entry.getKey() + ": " + entry.getOldValue() + "\n");
                    break;
                case UPDATED:
                    result.append(
                        "  - " + entry.getKey() + ": " + entry.getOldValue() + "\n" + "  + " + entry.getKey()
                            + ": " + entry.getNewValue() + "\n");
                    break;
                case DELETED:
                    result.append("  - " + entry.getKey() + ": " + entry.getOldValue() + "\n");
                    break;
                case CREATED:
                    result.append("  + " + entry.getKey() + ": " + entry.getNewValue() + "\n");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + entry.getStatus());
            }
        }
        result.append("}");
        return "{\n" + result;
    }
}
