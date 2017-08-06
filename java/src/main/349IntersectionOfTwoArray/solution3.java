public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null ){
            return null;
        }else if(nums1.length == 0|| nums2.length == 0){
            return new int[0];
        }
        if(nums1.length > nums2.length){
            return intersection(nums2, nums1);
        }
        quickSort(nums2, 0, nums2.length-1);
        Set<Integer> res = new HashSet<Integer>();
        for(int i: nums1){
            if(find(nums2, i)){
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        int counter = 0;
        for(int i: res){
            result[counter++] = i;
        }
        return result;
    }
    
    private boolean find(int[] data, int target){
        int start = 0; 
        int end = data.length -1;
        while(start <= end){
            int middle = start + (end-end)/2;
            int tmp = data[middle];
            if(target == tmp){
                return true;
            }else if(target > tmp){
                start = middle+1;
            }else{
                end = middle -1;
            }
        }
        return false;
    }
    
    private void quickSort(int[] data, int start, int end){
        if(start < end){
            int pos = partition(data, start, end);
            quickSort(data, start, pos-1);
            quickSort(data, pos+1, end);
        }
    }
    
    private int partition(int[] data, int a, int b){
        // we know that a, b 
        int pivot = data[b];
        int next = a-1;
        int end = b-1;
        while(a <= end){
            if(pivot > data[a]){
                swap(data, ++next, a);
            }
            a++;
        }
        swap(data, ++next, b);
        return next;
    }
    
    private void swap(int[] data, int a, int b){
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
