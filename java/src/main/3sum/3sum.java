public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( nums == null && nums.length <3)
        {
            return result ;
        }
        for(int i = 0; i < nums.length - 2 ; i++)
        {
            int low = i+1;
            int high = nums.length -1 ; 
            while( low < high )
            {
                int sum = nums[i] + nums[low] + nums[high] ; 
                if(sum == 0)
                {
                    result.add(Arrays.asList(nums[i],nums[low], nums[high]));
                    while(i < nums.length -1 && nums[i] == nums[i+1] )
                    {
                        i++;
                    }
                    while(low < nums.length -1 && nums[low+1] == nums[low])
                    {
                        low ++;
                    }
                    while( high > low && nums[high -1] == nums[high])
                    {
                        high --;
                    }
                    low ++;
                    high --;
               }
                else if( sum > 0)
                {
                    high --;
                }
                else
                {
                    low ++;
                }
            }
        }
        return result ;
        }
}

