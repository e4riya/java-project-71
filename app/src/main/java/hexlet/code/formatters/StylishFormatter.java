package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.ArrayList;

public class StylishFormatter implements CanFormat {
    @Override
    public String format(ArrayList<DiffEntry> diffs) {
        StringBuilder result = new StringBuilder();
        for (DiffEntry entry : diffs) {
            switch (entry.status()) {
                case STAYED:
                    result.append("    " + entry.key() + ": " + entry.oldValue() + "\n");
                    break;
                case UPDATED:
                    result.append(
                        "  - " + entry.key() + ": " + entry.oldValue() + "\n" + "  + " + entry.key()
                            + ": " + entry.newValue() + "\n");
                    break;
                case DELETED:
                    result.append("  - " + entry.key() + ": " + entry.oldValue() + "\n");
                    break;
                case CREATED:
                    result.append("  + " + entry.key() + ": " + entry.newValue() + "\n");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + entry.status());
            }
        }
        result.append("}");
        return "{\n" + result;
    }
}
