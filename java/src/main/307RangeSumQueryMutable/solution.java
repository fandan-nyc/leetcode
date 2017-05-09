public class NumArray {
    
    private final int[] binaryIndexTree;
    private final int len;
    private final int[] nums;
    public NumArray(int[] nums) {
        this.binaryIndexTree = new int[nums.length+1];
        this.len = nums.length;
        this.nums = nums.clone();
        for(int i = 0; i < nums.length; i++){
            updateHelper(i, nums[i]);
        }
    }
    
    private void updateHelper(int i, int diff){
        i += 1;
        while(i <= this.len ){
            binaryIndexTree[i] += diff;
            i += ( i & (-i));
        }
    }
    
    private int getSum(int i){
        i += 1; 
        int sum = 0 ;
        while( i > 0){
            sum += binaryIndexTree[i];
            i -= (i & (-i));
        }
        return sum;
    }
    
    public void update(int i, int val) {
        int diff = val - this.nums[i];
        updateHelper(i, diff);
        this.nums[i] = val;
        
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
