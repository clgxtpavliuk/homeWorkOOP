import java.util.HashMap;
import java.util.Map;

public class WordNumberConverter {
    private static Map<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put("Zero", 0);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        map.put("Seven", 7);
        map.put("Eight", 8);
        map.put("Nine", 9);
        map.put("Ten", 10);
    }

    public static Integer wordToNumber(String input) {
        Integer output = null;
        if (input != null) {
            output = map.get(input);
        }

        return output;
    }
}