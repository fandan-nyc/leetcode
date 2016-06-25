public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        // suppose that num1 and nums2 are sorted;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length];
        int count = 0;
        for(int i= 0, j = 0; i < nums1.length && j <nums2.length; i++,j++){
            if(nums1[i]  == nums2[j]){
                result[count++] = nums1[i];
            }else if(nums1[i] < nums2[j]){
                --j;
            }else{
                --i;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }
}
