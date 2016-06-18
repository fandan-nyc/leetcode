public class Solution {
    public List<Integer> majorityElement(int[] nums) { 
        if(nums ==  null || nums.length == 0)
            return new ArrayList<Integer>();
        int tmp1=  nums[0]-1;
        int tmp2 =  nums[0]-1;
        int counter1 = 0;
        int counter2 = 0;
        for(int i: nums){
            if(i == tmp1)
                counter1++;
            else if(i == tmp2)
                counter2++;
            else{
                if(counter1 == 0){
                    tmp1 = i;
                    counter1 = 1;
                }
                else if(counter2 == 0){
                    tmp2 = i;
                    counter2 =1;
                }
                else{
                    counter1--;
                    counter2--;
                }
            }
        }
         counter1 = 0;
         counter2 = 0;
        for(int i: nums){
            if(tmp1 == i)
                counter1++;
            else if(tmp2 == i)
                counter2++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(counter1 > nums.length/3)
            result.add(tmp1);
        if(counter2 > nums.length/3)
            result.add(tmp2);
        return result;
    }
}
