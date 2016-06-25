public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length; 
        int len2 = nums2.length;
        BitSet check = new BitSet();
        for(int i : nums1){
            check.set(i);
        }
        int[] result = new int[len1 > len2? len2: len1];
        int count = 0;
        for(int i: nums2){
            if(check.get(i)){
                result[count++] =i;
                check.flip(i);
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }
}
