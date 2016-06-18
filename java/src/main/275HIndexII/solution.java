public class Solution {
    public int hIndex(int[] citations) {
        int result = 0;
        int start = 0;
        int end = citations.length -1;
        while(start <= end){
            int middle = start + (end-start) /2 ;
            if(citations[middle] >= citations.length - middle){
                result = citations.length - middle;
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        return result;
    }
}
