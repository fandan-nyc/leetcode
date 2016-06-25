public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null  || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
       quickSort(nums1, 0, nums1.length-1);
      quickSort(nums2, 0, nums2.length-1);
      List<Integer> result = new ArrayList<Integer>();
      for(int i =0, j=0; i < nums1.length && j < nums2.length; i++, j++){
          if(nums1[i] == nums2[j]){
              result.add(nums1[i]);
                while(i < nums1.length-1 && nums1[i] == nums1[i+1]){
                    i++;
                }
                while(j < nums2.length-1 && nums2[j] == nums2[j+1]){
                    j++;
                }
          }else if(nums1[i] < nums2[j]){
              --j;
          }else if(nums1[i] > nums2[j]){
              --i;
          }
      }
      int[] resultArr = new int[result.size()];
      for( int i = 0 ;i < result.size(); i++){
          resultArr[i] = result.get(i);
      }
      return resultArr;
    }
    
    private void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return ;
        }
        int pivot = nums[start];
        int next = start+1;
        for(int i = start+1; i <= end; i++){
            if(nums[i] < pivot){
                swap(nums, i, next);
                next++;
            }
        }
        swap(nums, next-1, start);
        quickSort(nums, start, next-2);
        quickSort(nums, next, end);
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a]= nums[b];
        nums[b] =  tmp;
    }
    
}
