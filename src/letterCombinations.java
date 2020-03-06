import java.util.*;
import static java.util.Map.entry;

public class letterCombinations {
    static Map<String, String> digitMap = Map.ofEntries(
            entry("2","abc"),
            entry("3","def"),
            entry("4","ghi"),
            entry("5","jkl"),
            entry("6","mno"),
            entry("7","pqrs"),
            entry("8","tuv"),
            entry("9","wxyz"));

    static List<String> results = new ArrayList<>();

    // takes as arguments an ongoing letter combination and the next digits to check
    public static void backtrack(String combination, String next) {

        // If there is no more digits to check
        if (next.length() == 0) {
            // the combination is done
            results.add(combination);
            // If there are still digits to check
        } else {
            // Iterate over the letters mapping the next available digit
            String s = digitMap.get(next.substring(0, 1));

            // append the current letter to the combination
            // and proceed to the next digits
            next = next.substring(1);
            for (int i = 0; i < s.length(); i++) {
                String ss = s.substring(i, i + 1);
                backtrack(combination + ss, next);
            }
        }
    }

    public static List<String> solution(String digits) {
        if (digits.length() == 0) {
            return results;
        }
        backtrack("", digits);
        return results;
    }

    /* ------------------------------------not work--------------------------------------- */
    public List<String> mySolution(String digits) {
        Map<Character, String> digitMap = Map.ofEntries(
                entry('2',"abc"),
                entry('3',"def"),
                entry('4',"ghi"),
                entry('5',"jkl"),
                entry('6',"mno"),
                entry('7',"pqrs"),
                entry('8',"tuv"),
                entry('9',"wxyz"));

        List<String> results = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            tmp.add(digitMap.get(digits.charAt(i)));
        }
        return null;
    }

    public List<String> permutation(List<String> strs, List<String> results) {
        // todo: figure out how to permutate a string list
        if (strs.size() == 2) {
            String s1 = strs.get(0);
            String s2 = strs.get(1);
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    results.add(Character.toString(s1.charAt(i)) + Character.toString(s2.charAt(j)));
                    return results;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println(solution(s));
    }
}
