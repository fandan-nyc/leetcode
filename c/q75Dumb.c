void sortColors(int* nums, int numsSize) {
    int count[] = {0,0,0};
    for(int i = 0;i<numsSize;i++){
        ++count[nums[i]];
    }
    int start = 0;
    for(int i = 0; i < 3;i++){
        while(count[i] > 0){
            nums[start++] = i;
            --count[i];
        }
    }
}
