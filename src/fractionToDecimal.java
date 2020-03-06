import java.util.HashMap;
import java.util.Map;

public class fractionToDecimal {
    public static String mySolution(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // + or -
        res.append((numerator > 0) ^ (denominator > 0)? "-": "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        res.append(num/ den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        Map<Long, Integer> map = new HashMap<>();
        // a map whose key is the remainder, value is the index of the remainder in result string
        res.append('.');
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                // if the map contains the remainder, then add "()" to right place and break
                int index = map.get(num);
                res.insert(index, '(');
                res.append(')');
                break;
            } else {
                // if the map not contain the remainder, then put it in the map
                map.put(num, res.length());
            }

        }
        return res.toString();

    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(mySolution(2, 3));
    }
}
