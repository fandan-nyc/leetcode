public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         Arrays.sort(nums);
         boolean[] visited = new boolean[nums.length];
         List<Integer> result = new ArrayList<Integer>();
         for(int i = 0; i <  nums.length; i ++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(nums[i]);
            for(int j = 0; j < nums.length;j++){
                if(j != i){
                    boolean fit = true;
                    for(int k: tmp){
                        if(!(k%nums[j]  == 0 || nums[j]%k== 0)){
                            fit = false;
                            break;
                        }
                    }
                    if(fit){
                        tmp.add(nums[j]);
                        visited[j] =  true;
                    }
                }
            }
            if(tmp.size() > result.size()){
                result = new ArrayList<Integer>(tmp);
            }
        }
        return result;
    }
}
