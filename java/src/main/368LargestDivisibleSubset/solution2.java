public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null  || nums.length == 0){
            return new ArrayList<Integer>();
        }
        Arrays.sort(nums);
        int[] totalLen = new int[nums.length];
        int[] parent   = new int[nums.length];
        int max = 0 ;
        int position = 0;
        for(int i  = nums.length-1; i >= 0; i--){
            for(int j = i; j < nums.length; j++){
                if(nums[j] % nums[i] == 0 && totalLen[i] < totalLen[j] +1 ){
                    totalLen[i] = totalLen[j]+1;
                    parent[i] = j;
                    if(max <= totalLen[i]){
                        max = totalLen[i];
                        position = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.add(nums[position]);
        while(position != parent[position]){
            position = parent[position];
            result.add(nums[position]);
        }
        return result;
    }
}
