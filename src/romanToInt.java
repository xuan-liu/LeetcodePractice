public class romanToInt {
    public static int mySolution_v2(String s) {
        //First, convert each char into according value.
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }

        // Then iterate all the value, if (nums[j] == nums[j + 1] / 5 || nums[j] == nums[j + 1] / 10), then sum -= nums[j]
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j < nums.length - 1 && (nums[j] == nums[j + 1] / 5 || nums[j] == nums[j + 1] / 10)) sum -= nums[j];
            else sum += nums[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(mySolution_v2("III"));
    }
}
