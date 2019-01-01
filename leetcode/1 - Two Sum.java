/*
*   Idea: We can use the difference between the number we find and our target number to store in
*         a hashmap so that we can simply check if a value is in the map, if so then we have our pair.
*
*   Run Time: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x = 0; x < nums.length; x++){
            if(map.containsKey(nums[x])){
                return new int[]{map.get(nums[x]), x};
            } else{
                map.put(target - nums[x], x);
            }
        }
        
        return null;
    }
}