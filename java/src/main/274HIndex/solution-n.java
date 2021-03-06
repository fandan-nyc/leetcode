//counting sort
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int[] count = new int[citations.length+1];
        for(int i = 0; i < citations.length; i++){
            count[Math.min(citations[i], citations.length)] ++;
        }
        int total = 0;
        for(int i = citations.length; i >= 0 ; i--){
            total += count[i];
            if(total >= i){
                return i;
            }
        }
        return -1;
    }
}
// the previous one work, but bad code

public class Solution {
    public int hIndex(int[] citations) {
        if(citations ==  null || citations.length == 0){
            return 0;
        }
        int[] store = new int[citations.length];
        for(int i = 0; i < citations.length; i ++){
            int k = (citations[i] >= citations.length) ? (citations.length-1): (citations[i]-1);
            if(k >=0)
                store[k] ++;
        }
        if(store[store.length-1] >= store.length)
            return store.length;
        for(int i  = store.length-2;i >= 0; i--){
            store[i] += store[i+1];
            if(store[i] >= i+1)
                return i+1;
        }
        return 0;
    }
}
