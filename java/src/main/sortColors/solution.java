public void sortColors(int[] nums) {
         int start = 0, end=nums.length -1;
         int i = 0;
         while(i <= end){
             if(nums[i] == 0){
                swap(nums, start, i);
                start ++;
             }else if(nums[i] == 2){
                 swap(nums, end,i);
                 --end;
                 --i;
             }
             ++i;
         }
    }
    private  void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
