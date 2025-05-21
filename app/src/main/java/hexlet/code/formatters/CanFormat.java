package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.ArrayList;

public interface CanFormat {
    String format(ArrayList<DiffEntry> diffs);
}
