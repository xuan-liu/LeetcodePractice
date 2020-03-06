import java.util.HashSet;
import java.util.Set;

public class isHappy {

    /* if n=xyz (which means n = x*10^2 + y*10^1 + z*10^0), then the function return x^2 + y^2 + z^2 */
    private static int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n /= 10;
        }
        return sum;
    }

    public static boolean mySolution(int n) {
        // use one hashset to store all the previous digit square sum
        Set<Integer> sumSet = new HashSet<>();
        int sum = digitSquareSum(n);

        // if the the square sum already in the hashset, return false
        while (!sumSet.contains(sum)) {
            sumSet.add(sum);
            sum = digitSquareSum(sum);
            if (sum == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(19));
    }
}
