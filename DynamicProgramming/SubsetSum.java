package DynamicProgramming;

public class SubsetSum {
    static boolean canPartition(int[] num, int sum) {
        // TODO: Write - Your - Code
        return canPartitionRecursive(num, sum, 0);
    }

    public static boolean canPartitionRecursive(int[] num, int sum, int index) {
        if (sum == 0)
            return true;

        if (index >= num.length) {
            return false;
        }

        if (num[index] <= sum) {
            if (canPartitionRecursive(num, sum - num[index], index + 1))
                return true;
        }

        return canPartitionRecursive(num, index + 1, sum);
    }

    public static void main(String[] args) {
        SubsetSum subSet = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        int S = 6;
        System.out.println(subSet.canPartition(num, S));
    }
}
