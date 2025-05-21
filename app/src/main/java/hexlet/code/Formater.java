package hexlet.code;

import hexlet.code.formatters.CanFormat;
import hexlet.code.formatters.JSONFormater;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import hexlet.code.formatters.WrongFormatException;

public class Formater {
    public static CanFormat getFormatter(String format) {
        switch (format) {
            case "stylish":
                return new StylishFormatter();
            case "plain":
                return new PlainFormatter();
            case "json":
                return new JSONFormater();
            default:
                throw new WrongFormatException("Unsupported format: " + format);
        }
    }
}
