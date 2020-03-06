public class countPrimes {
    public static int mySolution(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        // iterate from 2 to n-1 to check whether notPrime[i] == false
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                // if int i is a prime, add count and record all the nums = i * j be not prime
                count += 1;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(10));
    }
}
