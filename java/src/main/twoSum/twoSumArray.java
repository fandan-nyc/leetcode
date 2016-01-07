public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int i = 0 ;
        int j = nums.length -1 ;
        int[] result = null ;
        while(i < j)
        {
            if(tmp[i] + tmp[j] == target){
                result = new int[]{tmp[i],tmp[j]};
                break;
            }
            else if(tmp[i] + tmp[j] < target)
                i++;
            else 
                j--;
        }
        if(result == null)
            return null;
        else
            return getPosition(nums,result);
    }
    
    private int[] getPosition(int[] nums, int[] result)
    {   
        int[] output = new int[2];
        int counter = 0;
        for(int i=0;i<nums.length; i++)
                if(nums[i] == result[0] || nums[i] == result[1])
                    output[counter++] = i+1;
        return output;
    }
}
