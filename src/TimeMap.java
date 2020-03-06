import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    /* set key in the map, whose value is a tree map -- key is the timestamp, value is the value */
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> timeMap = new TreeMap<>();
            timeMap.put(timestamp, value);
            map.put(key, timeMap);
        }
    }

    /* returns a value with timestamp_prev <= timestamp. If there are multiple such values, returns the one with the
    largest timestamp_prev. If there are no values, returns "" */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timeMap = map.get(key);
        Integer t = timeMap.floorKey(timestamp);
        if (t == null) {
            return "";
        } else {
            return timeMap.get(t);
        }
    }

}
