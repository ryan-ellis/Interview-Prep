// Not the most efficient solution, should go back and improve.
class Solution {
    public void rotate(int[] nums, int k) {
        // Use mod to limit number of rotations based on length
        int rotations = k % nums.length;
        
        // This will help us identify how many rotations we need to make
        int numberOfRotations = nums.length - rotations - 1;
        
        for(int x = numberOfRotations - 1; x >= 0; x--){
            int temp = nums[0];
            for(int j = 1; j <= nums.length - 1; j++){
                nums[j - 1] = nums[j];
            }
            nums[nums.length - 1] = temp;
        }
    }
}