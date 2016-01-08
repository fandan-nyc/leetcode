public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if(totalLen %2 == 1)
            return findKthNum(totalLen/2+1, nums1, 0, nums2, 0);
        else
            return ((double)findKthNum(totalLen/2+1, nums1, 0, nums2, 0) + (double)findKthNum(totalLen/2, nums1, 0, nums2, 0))/2;
    }
    
    private int findKthNum(int k, int[] num1, int start1, int[] num2, int start2){
        if(num1.length - start1 > num2.length - start2)
            return findKthNum(k,num2, start2, num1, start1);
        if(num1.length - start1 <= 0)
            return num2[start2 + k -1];
       if(k == 1)
          return Math.min(num1[start1], num2[start2]);
        int k1 = Math.min(num1.length - start1, k/2);
        int k2 = k - k1;
        int diff = num1[start1 + k1-1] - num2[start2 + k2-1];
        if(diff < 0)
            return findKthNum(k-k1, num1, start1+k1, num2, start2);
        else 
            return findKthNum(k-k2, num1, start1, num2, start2+k2);
    }
}
