public class numberToWords {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String mySolution(int num) {
        if (num == 0) {
            return "Zero";
        }

        String words = "";
        int i = 0;

        while (num > 0) {
            int remainder = num % 1000;
            if (remainder != 0) {
                words = numLessThan999(remainder) + THOUSANDS[i] + " " + words;
            }

            num = num / 1000;
            i += 1;
        }

        return words.trim();
    }

    /* convert num less than 999 to words */
    public static String numLessThan999(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + numLessThan999(num % 10) ;
        } else {
            return LESS_THAN_20[num / 100] + " " + "Hundred" + " " + numLessThan999(num % 100);
        }
    }

    public static void main(String[] args) {
        System.out.println(mySolution(1234567891));
    }
}
