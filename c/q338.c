/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* countBits(int num, int* returnSize) {
   // returnSize tells, how long the returned array is 
   *returnSize = num+1;
   int *result = (int*) malloc(sizeof(int)*(*returnSize));
   result[0] = 0;
   int i = 0; 
   int tmp ;
   while(++i <= num){
       tmp= i  & (i - 1);
       result[i]= result[tmp] + 1;
   }
   return result;
}
