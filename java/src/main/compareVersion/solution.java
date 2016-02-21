public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0 ; i < Math.max(v1.length, v2.length); i++){
            int first = 0; 
            int second = 0;
            if(i < v1.length){
                first = Integer.valueOf(v1[i]);
            }
            if(i < v2.length){
                second = Integer.valueOf(v2[i]);
            }
            if(first > second){
                return 1;
            }
            else if (first < second){
                return -1;
            }
        }
        return 0;        
    }
}
