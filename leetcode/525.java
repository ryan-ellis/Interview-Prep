class Solution {
    public int findMaxLength(int[] nums) {
        for(int x = 0; x < nums.length; x++){
            if(nums[x] == 0) {
                nums[x] = -1;
            }
        }
        
        //map<sum, integer>
        HashMap<Integer, Integer> sumIndexes = new HashMap<Integer, Integer>();
        
        //in order to cover special case of [0, 1]
        //anytime the entire array contains an equal number of 0's and 1's
        sumIndexes.put(0, -1);
        
        int sum = 0; 
        int max = 0;
        
        for(int x = 0; x < nums.length; x++){
            sum += nums[x];
            if (sumIndexes.containsKey(sum)) {
                max = Math.max(max, x - sumIndexes.get(sum));
            }
            else {
                sumIndexes.put(sum, x);
            }
        }
        
        return max;
    }
}
