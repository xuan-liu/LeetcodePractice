public class addBinary {
    public static String mySolution(String a, String b) {
        String res = "";
        int carry = 0;
        int i = 0;

        // iterate until both a and b finish
        while (i < a.length() || i < b.length()) {
            // if a is already finish, aa = 0
            int aa = i < a.length()? a.charAt(a.length() - 1 - i) - '0': 0;
            int bb = i < b.length()? b.charAt(b.length() - 1 - i) - '0': 0;
            int sum = aa + bb + carry;

            // this two statement is equal to all the if-else statement
            res = sum % 2 + res;
            carry = sum / 2;

//            if (sum == 0) {
//                res = "0" + res;
//                carry = 0;
//            } else if (sum == 1) {
//                res = "1" + res;
//                carry = 0;
//            } else if (sum == 2) {
//                res = "0" + res;
//                carry = 1;
//            } else {
//                res = "1" + res;
//                carry = 1;
//            }

            i += 1;
        }

        // if there are still carry, add it
        if (carry == 1) {
            res = "1" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("1010", "1011"));
    }
}
