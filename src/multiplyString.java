public class multiplyString {
    public static String mySolution(String num1, String num2) {
        // Start from right to left, perform multiplication on every pair of digits, and add them together.
        // the result of `num1[i] * num2[j]` will be placed at the indices `[i + j`, `i + j + 1]` in the result array

        //        1 |2| 3   i = 1
        //          |4| 5   j = 0
        //      ---------
        //           1  5
        //        1  0
        //     0  5
        //        1  2
        //    |0  8|        i+j=1, i+j+1=2
        //  0  4
        //   -----------
    // idx: 0  1  2  3  4

        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];

        // compute the multiplication
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + res[p2];

                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }

        // convert the res array into string
        StringBuilder sb = new StringBuilder();
        for (int r: res) {
            // avoid the res[0] = 0
            if (!(sb.length() == 0 && r == 0)) {
                sb.append(r);
            }
        }
        return sb.length() == 0? "0": sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mySolution("123", "456"));
    }
}
