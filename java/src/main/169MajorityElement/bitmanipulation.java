public class Solution {
    public int majorityElement(int[] nums) {
        int[] bits = new int[32];
        for(int i: nums){
            for(int j = 0; j < 32; j++){
                bits[j] += ((i & (1<<j)) == 0 ? 0 :1);
            }
        }
        int result = 0; 
        for(int i = 0; i < 32; i++){
            if(bits[i] > nums.length/2){
                result += 1 << i;
            }
        }
        return result;
    }
}

// better way
 class BetterSolution {
    public int majorityElement(int[] nums) {
        int result = 0; 
        for(int i = 0; i < 32; i++){
            int counter = 0;
            for(int j: nums){
                if( ((j >> i) & 1) == 1)
                    counter++;
                if(counter > nums.length / 2){
                    result |= (1 << i);
                    break;
                }
            }
        }
        return result;
    }
}
