public class canCompleteCircuit {
    public static int mySolution(int[] gas, int[] cost) {
        // iterate the array to get sumGas and sumCost, and test every node to see whether it can be a start
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                // if tank is negative, set start to be the next station, set tank to 0 again
                start = i + 1;
                tank = 0;
            }
        }

        // if sumGas >= sumCost, then there must be a solution
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(mySolution(gas, cost));
    }
}
