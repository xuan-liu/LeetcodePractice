import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    Map<Integer, Integer> map;
    // key is the val, value is the index of the val in the arrayList
    List<Integer> list;
    // the list maintain all the val
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // if map not containKey val, then put it in map and add it to the list, otherwise return false
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // if map containKey val, then remove it from the map, and find it in list, swap it with the last item in the list
        // delete the last item in the list. otherwise return false
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int n = list.size() - 1;
        if (index < n) {
            // if not the last item, then in the list set item in index as the last item, in map put {last item: index}
            int tmp = list.get(n);
            list.set(index, tmp);
            map.put(tmp, index);
        }
        map.remove(val);
        list.remove(n);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // get a random index, and get the according item in the list
        return list.get(rand.nextInt(list.size()));
    }
}
