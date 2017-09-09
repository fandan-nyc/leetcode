class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(1, k, n, res, tmp);
        return res;
    }
    
    private void helper(int start, int k, int n, List<List<Integer>> res, List<Integer> tmp){
        if(k == 0 && n == 0){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        
        int size = tmp.size();
        for(int i = start; i <= n && i < 10; i++){
            tmp.add(i);
            helper(i+1, k-1, n-i, res, tmp);
            tmp.remove(size);
        }
    }
}
