class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] mins = new int[n];

        mins[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            mins[i] = Math.min(mins[i + 1], nums[i]);
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);

            if(max - mins[i] <= k){
                return i;
            }
        }

        return -1;
    }
}