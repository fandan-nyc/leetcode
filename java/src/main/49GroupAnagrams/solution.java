public class Solution {
    private int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<String>> result = new ArrayList<List<String>>();
        for(String str: strs){
            int key = 1;
            for(int i = 0 ; i < str.length();i++){
                key *= prime[str.charAt(i) - 'a'];
            }
            if(map.containsKey(key)){
                result.get(map.get(key)).add(str);
            }else{
                map.put(key,result.size());
                List<String> tmp = new ArrayList<String>();
                tmp.add(str);
                result.add(new ArrayList<String>(tmp));
            }
        }
        return result;
    }
}
