package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(Map<String, String> first, Map<String, String> second) {
        Map<String, String> firstMap = new TreeMap<>(first);
        Map<String, String> secondMap = new TreeMap<>(second);
        StringBuilder result = new StringBuilder();
        for (String mapKey : firstMap.keySet()) {
            String firstValue = firstMap.get(mapKey);
            String secondValue = secondMap.get(mapKey);
            if (secondValue != null) {
                if (firstValue.equals(secondValue)) {
                    result.append("    " + mapKey + ": " + firstValue + "\n");
                } else {
                    result.append(
                        "  - " + mapKey + ": " + firstValue + "\n" + "  + " + mapKey + ": " + secondValue + "\n");
                }
                secondMap.remove(mapKey);
            } else {
                result.append("  - " + mapKey + ": " + firstValue + "\n");
            }
        }
        for (String mapKey : secondMap.keySet()) {
            result.append("  + " + mapKey + ": " + secondMap.get(mapKey) + "\n");
        }
        result.append("}");
        return "{\n" + result.toString();
    }
}
