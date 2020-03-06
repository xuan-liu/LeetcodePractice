import java.util.*;

public class groupAnagrams {
    public static List<List<String>> mySolution(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for (String s: strs) {
            // count every letter's frequency in s
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count[c - 'a'] += 1;
            }

            // convert all the count into string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String sKey = sb.toString();

            // set the string as key in map, add the original string as value
            if (map.containsKey(sKey)) {
                map.get(sKey).add(s);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                map.put(sKey, tmp);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(mySolution(s));
    }
}

