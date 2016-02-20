public class NumArray {
 
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int tmp = 0;
        int counter = 0;
        for(int i: nums){
            sums[counter++] = tmp + i;
            tmp += i;
        }
    }

    public int sumRange(int i, int j) {
        if( i == 0){
            return sums[j];
        }
        return sums[j] - sums[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
