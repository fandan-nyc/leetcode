/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
static int pow2( int n){
    return 1<<n;
}

int* grayCode(int n, int* returnSize) {
    int * result = (int *) malloc( pow2(n)*sizeof(int));
    *returnSize = pow2(n);
    *result = 0;
    int bit;
    for(int i  = 0; i < n;i++){
        bit = pow2(i);
        for(int j = pow2(i); j < pow2(i+1);j++ ){
            *(result + j) = bit + *(result + pow2(i+1)-1-j);
        }
    }
    return result;
}
