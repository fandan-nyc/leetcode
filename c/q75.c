static void swap(int*, int, int);

void sortColors(int* nums, int numsSize) {
    int start = 0;
    int end = numsSize-1;
    int i = 0;
    while(i <= end){
        if(nums[i] == 0){
            swap(nums, i, start);
            ++start;
        }else if(nums[i] == 2){
            swap(nums, i, end);
            --end;
            --i;
        }
        ++i;
    }
}

static void swap(int* nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
