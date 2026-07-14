class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: result[i] = product of everything to the LEFT of i
        result[0] = 1;                       // nothing to the left of index 0
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Pass 2: multiply in the product of everything to the RIGHT of i
        int right = 1;                       // nothing to the right of the last index
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;   // combine left (already there) with right
            right = right * nums[i];         // update running right product
        }

        return result;
    }
}