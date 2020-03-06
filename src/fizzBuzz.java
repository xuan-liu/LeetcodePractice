import java.util.LinkedList;
import java.util.List;

public class fizzBuzz {
    public static List<String> mySolution(int n) {
        List<String> res = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(15));
    }
}
