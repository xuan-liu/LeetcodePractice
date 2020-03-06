public class intToRoman {
    public static String solution(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Let num divide 1000 then 100 etc, then list all the cases
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }


    /* --------------------------------------------------------------------------- */
    public static String mySolution(int num) {
        StringBuilder result = new StringBuilder();
        String[] roman = new String[]{"M", "D", "C", "L", "X", "V", "I"};

        int base = num / 1000;
        int res = num % 1000;
        while (base > 0) {
            result.append('M');
            base -= 1;
        }

        int index = 1;
        for (int i = 100; i > 0; i /= 10) {
            base = res / i;
            res = res % i;
            if (base == 4) {
                result.append(roman[index + 1] + roman[index]);
            } else if (base == 9) {
                result.append(roman[index + 1] + roman[index - 1]);
            } else if (base > 4) {
                result.append(roman[index]);
                while (base > 5) {
                    result.append(roman[index + 1]);
                    base -= 1;
                }
            } else {
                while (base > 0) {
                    result.append(roman[index + 1]);
                    base -= 1;
                }
            }
            index += 2;
        }

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(mySolution(9));
    }
}
