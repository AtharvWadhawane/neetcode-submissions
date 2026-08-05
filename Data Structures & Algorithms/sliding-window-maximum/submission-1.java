class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int l = 0, r = k - 1;
        int idx = 0;

        while (r < n) {
            int currmax = findmax(nums, l, r);
            result[idx++] = currmax;
            l++;
            r++;
        }

        return result;
    }

    public static int findmax(int[] arr, int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}