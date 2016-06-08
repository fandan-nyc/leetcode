public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, result, new ArrayList<Integer>());
        return result;
    }
    
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> item){
        if(item.size() == nums.length){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i: nums){
            if(validateItem(i, item)){
                helper(nums, result, item);
                item.remove(item.size()-1);
            }
        }
    }
    
    private boolean validateItem(int ele, List<Integer> item){
        if( item.contains(ele)){
            return false;
        }else{
            return item.add(ele);
        }
    }
}
